package chirikualii.com.footballapps.common.scheduler

import io.reactivex.Scheduler

/**
 * Created by chirikualii on 11/8/18
 * github.com/chirikualii
 */
interface SchedulerProvider {
    fun ui(): Scheduler
    fun computation(): Scheduler
    fun trampoline(): Scheduler
    fun newThread(): Scheduler
    fun io(): Scheduler
}