package chirikualii.com.footballapps.presentation.ui.favorite


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import chirikualii.com.footballapps.R
import chirikualii.com.footballapps.presentation.base.BaseFragment


class FavoriteTeamFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite_list,container,false)
    }


}
