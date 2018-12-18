package news.biubiubiu.com.biubiubiunews.view.fragment;


import news.biubiubiu.com.biubiubiunews.R;



/**
 *
 * @author WJB
 * @date 2018/11/22
 * 社会新闻页面Fragment
 */
public class SocietyFragment extends BaseFragment {
    @Override
    public void onGetNewType() {
        getDataFromServer(getString(R.string.type_society));
    }
}
