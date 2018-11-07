package chirikualii.com.footballapps.presentation.ui.prevmatch

import chirikualii.com.footballapps.common.scheduler.TestSchedulerProvider
import chirikualii.com.footballapps.data.repo.MatchRepo
import chirikualii.com.footballapps.presentation.model.Match
import chirikualii.com.footballapps.presentation.ui.match.prevmatch.IPrevMatchView
import chirikualii.com.footballapps.presentation.ui.match.prevmatch.PrevMatchPresenter
import io.reactivex.Flowable
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Created by chirikualii on 11/8/18
 * github.com/chirikualii
 */
class PrevMatchPresenterTest {

    @Mock
    lateinit var repo: MatchRepo

    lateinit var presenter: PrevMatchPresenter

    val match = mutableListOf<Match>()

    lateinit var eventFlowable: Flowable<List<Match>>

    val testSchedulerProvider = TestSchedulerProvider(TestScheduler())
    @Mock
    lateinit var view: IPrevMatchView


    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)

        eventFlowable = Flowable.just(match)
        presenter = PrevMatchPresenter(repo)
        presenter.bind(view)
        presenter.bindTest(testSchedulerProvider)
        `when`(repo.loadPrevMatchList("4328")).thenReturn(eventFlowable)


    }

    @Test
    fun test_repo_prev_match() {
        presenter.performLoadData("4328")
        testSchedulerProvider.testScheduler.triggerActions()
        verify(repo).loadPrevMatchList("4328")


    }
}