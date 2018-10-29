package hu.bluesystem.testselfupdatingbehavoiur;

/**
 *
 * @author sfeher
 */
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.hibernate.Query;

/**
 * Általános FilteredDetectionDataProvider
 *
 * @author sfeher
 */
public class HrpAppPropertiesDataProvider extends FilteredDetectionDataProvider<HrpAppProperties, String, HrpAppProperties> {

    private static final Logger LOG = Logger.getLogger(HrpAppPropertiesDataProvider.class.getName());

    private  Object lastFilter;
    private  HrpAppProperties filter = new HrpAppProperties();
    private  List<HrpAppProperties> filtered;
    final private SortableDataProviderComparator comparator = new SortableDataProviderComparator();
    private Query query;
    private String Q;
    List<HrpAppProperties> initlist;
    boolean voltfilter = Boolean.FALSE;


    public HrpAppPropertiesDataProvider(HrpAppProperties filter) {        
        this.filter = (HrpAppProperties) filter;
        initList();
    }

    @Override
    public Iterator<HrpAppProperties> iterator(long first, long count) {
        Collections.sort(filtered, comparator);
        return (Iterator<HrpAppProperties>) filtered.subList((int) first, Math.min((int) (first + count), filtered.size())).iterator();
    }

    @Override
    public long size() {
        if (isFiltered()) {
            initList();
        }
        return filtered == null ? 0 : filtered.size();
    }

    @Override
    public IModel<HrpAppProperties> model(final HrpAppProperties object) {
        return new AbstractReadOnlyModel<HrpAppProperties>() {

            @Override
            public HrpAppProperties getObject() {
                return object;
            }
        };
    }

    private void initList() {
        
    }

    //  }
    @Override
    public HrpAppProperties getFilterState() {
        return filter;
    }

    @Override
    public void setFilterState(HrpAppProperties t) {
        this.filter = t;
    }

}
