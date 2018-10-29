package hu.bluesystem.testselfupdatingbehavoiur;

import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.HeadersToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.NavigationToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilterForm;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilterToolbar;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.OddEvenItem;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;

public class HomePage extends BasePage {

    private static final long serialVersionUID = 1L;

    public HomePage() {
        super();
        Populate();
    }

    private void Populate() {
        WebMarkupContainer container = new WebMarkupContainer("datatablecontainer");
        container.setOutputMarkupId(true);
        container.add(new Label("title", new ResourceModel("appproperties.title")));
        List<IColumn<HrpAppProperties, String>> columns = new ArrayList<IColumn<HrpAppProperties, String>>();
        HrpAppPropertiesDataProvider dataprovider = new HrpAppPropertiesDataProvider(new HrpAppProperties());
        dataprovider.setSort("propKey", SortOrder.ASCENDING);
        final DataTable table = new DataTable("datatable", columns, dataprovider, 10) {

            @Override
            protected Item newRowItem(String id, int index, IModel model) {
                return new OddEvenItem(id, index, model);
            }

            @Override
            protected void onDetach() {
                super.onDetach(); 
            }
            
        };
        FilterForm filterForm = new FilterForm("filterForm", dataprovider) {

            private static final long serialVersionUID = 1L;

            @Override
            protected void onError() {
                super.onError(); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            protected void onSubmit() {
                table.setCurrentPage(0);
            }
        };
        table.addTopToolbar(new HeadersToolbar(table, dataprovider));
        table.addBottomToolbar(new NavigationToolbar(table));
        table.addTopToolbar(new FilterToolbar(table, filterForm));
        filterForm.add(table);
        container.add(filterForm);
        add(container);

    }
}
