/*
 * Blue System Kft 2017  
 * Minden jog fenntartva!
 *
 */
package hu.bluesystem.testselfupdatingbehavoiur;

import java.io.Serializable;
import java.util.Comparator;
import org.apache.log4j.Logger;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.IFilterStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.PropertyModel;

/**
 *
 * @author sfeher
 * @param <T>
 * @param <T2> helper osztály, ha van
 * @param <String>
 */
public abstract class FilteredDetectionDataProvider<T, String, T2> extends SortableDataProvider<T, String> implements IFilterStateLocator<T2> {

    private static final Logger LOG = Logger.getLogger(FilteredDetectionDataProvider.class.getName());

    private Boolean refresh;

    public FilteredDetectionDataProvider() {
        refresh = Boolean.FALSE;
    }

    private Object lastFilter;

    public Boolean isFiltered() {
        Boolean ret = Boolean.FALSE;
        try {
            if (getFilterState() != null) {
                Class clazz = Class.forName(getFilterState().getClass().getName());
                Object o = clazz.newInstance();

                if (o.hashCode() != getFilterState().hashCode()) { // van a filterben érték
                    if (lastFilter != null && lastFilter.hashCode() != (getFilterState().hashCode())) { // utolsó filterhez képes változott
                        ret = Boolean.TRUE;
                        lastFilter = getFilterState().hashCode(); // filter tároljuk
                    } else if (lastFilter == null) { // van a filterben érték és még nem volt szűrve
                        ret = Boolean.TRUE;
                        lastFilter = getFilterState().hashCode(); // filter tároljuk
                    }

                } else {
                    if (lastFilter != null) { // volt már szűrve, de reseteltük
                        ret = Boolean.TRUE;
                    }
                    lastFilter = null;
                }
            } else {
                ret = Boolean.TRUE;
                lastFilter = null;
            }

        } catch (ClassNotFoundException ex) {
            LOG.error(ex);
        } catch (InstantiationException ex) {
            LOG.error(ex);
        } catch (IllegalAccessException ex) {
            LOG.error(ex);
        }
        return ret;
    }

    @Override
    public abstract T2 getFilterState();

    @Override
    public abstract void setFilterState(T2 t);

    @Override
    public void detach() {
        refresh = Boolean.TRUE;
    }

    class SortableDataProviderComparator implements Comparator, Serializable {

        @Override
        public int compare(Object o1, Object o2) {
            int result = 0;

            try {
                PropertyModel<Comparable> model1 = new PropertyModel<Comparable>(o1, getSort().getProperty().toString());
                PropertyModel<Comparable> model2 = new PropertyModel<Comparable>(o2, getSort().getProperty().toString());

                if (model1.getObject() == null && model2.getObject() == null) {
                    result = 0;
                } else {
                    if (model1.getObject() == null) {
                        result = -1;
                    } else if (model2.getObject() == null) {
                        result = 1;
                    } else {
                        result = model1.getObject().compareTo(model2.getObject());
                        if (!getSort().isAscending()) {
                            result = -result;
                        }
                    }
                }

            } catch (Exception e) {
                LOG.error(e);
            }

            return result;
        }

    }

    public void setLastFilter(Object lastFilter) {
        this.lastFilter = lastFilter;
    }

    public Object getLastFilter() {
        return lastFilter;
    }

}
