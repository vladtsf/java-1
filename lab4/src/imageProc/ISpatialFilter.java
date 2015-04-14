package imageProc;

import imageProc.SpatialFilter.Filter;

public interface ISpatialFilter {
  public void setFilter(Filter filter);
  public void apply();
}
