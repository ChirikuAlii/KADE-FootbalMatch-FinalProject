package chirikualii.com.footballapps.presentation.ui.nextmatch

import chirikualii.com.footballapps.common.scheduler.TestSchedulerProvider
import chirikualii.com.footballapps.data.repo.MatchRepo
import chirikualii.com.footballapps.presentation.model.Match
import chirikualii.com.footballapps.presentation.ui.match.nextmatch.INextMatchView
import chirikualii.com.footballapps.presentation.ui.match.nextmatch.NextMatchPresenter
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
class NextMatchPresenterTest {

    @Mock
    lateinit var repo: MatchRepo

    @Mock
    lateinit var view: INextMatchView

    lateinit var presenter: NextMatchPresenter

    val match = mutableListOf<Match>()

    lateinit var eventFlowable: Flowable<List<Match>>

    val testSchedulerProvider = TestSchedulerProvider(TestScheduler())

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        eventFlowable = Flowable.just(match)
        presenter = NextMatchPresenter(repo)
        presenter.bind(view)
        presenter.bindTest(testSchedulerProvider)
        `when`(repo.loadNextMatchList("4328")).thenReturn(eventFlowable)

    }

    @Test
    fun test_repo_next_match() {
        presenter.performLoadData("4328")
        testSchedulerProvider.testScheduler.triggerActions()
        verify(repo).loadNextMatchList("4328")
    }
}