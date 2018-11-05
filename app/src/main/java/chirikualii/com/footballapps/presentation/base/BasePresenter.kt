package chirikualii.com.footballapps.presentation.base

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by chirikualii on {DATE}
 */
open class BasePresenter<T : BaseView> {

    protected val disposables = CompositeDisposable()
    protected var view: T? = null
    // lateinit var scheduler : SchedulerProvider

    /*fun bindTest(scheduler: SchedulerProvider){
        this.scheduler = scheduler
    }*/
    fun bind(view: T) {
        this.view = view
    }

    private fun unbind() {
        this.view = null
    }

    fun destroy() {
        if (!disposables.isDisposed)
            disposables.dispose()
        unbind()
    }
}