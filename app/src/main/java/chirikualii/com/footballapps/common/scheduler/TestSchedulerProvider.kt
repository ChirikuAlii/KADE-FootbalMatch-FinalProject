package chirikualii.com.footballapps.common.scheduler

import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler

/**
 * Created by chirikualii on 11/8/18
 * github.com/chirikualii
 */
class TestSchedulerProvider constructor(val testScheduler: TestScheduler) : SchedulerProvider {

    override fun ui(): Scheduler {
        return testScheduler
    }

    override fun computation(): Scheduler {
        return testScheduler
    }


    override fun trampoline(): Scheduler {
        return testScheduler
    }

    override fun newThread(): Scheduler {
        return testScheduler
    }

    override fun io(): Scheduler {
        return testScheduler
    }
}