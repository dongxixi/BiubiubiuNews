package news.biubiubiu.com.biubiubiunews.view.fragment;

import news.biubiubiu.com.biubiubiunews.R;



/**
 *
 * @author WJB
 * @date 2018/11/22
 * 科技新闻页面Fragment
 */
public class TechnologyFragment extends BaseFragment {
    @Override
    public void onGetNewType() {
        getDataFromServer(getString(R.string.type_technology));
    }
}
