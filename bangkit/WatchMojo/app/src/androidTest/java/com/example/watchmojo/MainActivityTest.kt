package com.example.watchmojo

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.watchmojo.utility.DummyData
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private val dummyMovie = DummyData.generateDataMovieDummy()
    private val dummyTvShow = DummyData.generateDataTvShowDummy()

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loadCarouselList() {
        Espresso.onView(withId(R.id.carouselView)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun loadMovieList() {
        Espresso.onView(withId(R.id.movieRv)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.movieRv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun detailListMovie() {
        Espresso.onView(withId(R.id.movieRv))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.movieRv))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
        Espresso.onView(withId(R.id.movieRv))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5,
                        ViewActions.click()
                ))
        Espresso.onView(withId(R.id.img_item_photo))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.img_full))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_title_det))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_desc_det))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.tv_title_det))
                .check(ViewAssertions.matches(withText(dummyMovie[5].name)))
        Espresso.onView(withId(R.id.tv_desc_det))
                .check(ViewAssertions.matches(withText(dummyMovie[5].desc)))

        Espresso.pressBack()
    }

    @Test
    fun loadTvShowList() {
        Espresso.onView(withText("Tv Shows")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.tvShowRv)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tvShowRv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun detailListTvShow() {
        Espresso.onView(withText("Tv Shows")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.tvShowRv))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tvShowRv))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
        Espresso.onView(withId(R.id.tvShowRv))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5,
                        ViewActions.click()
                ))
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.img_full))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.img_item_photo))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_title_det))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_desc_det))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.tv_title_det))
                .check(ViewAssertions.matches(withText(dummyTvShow[5].name)))
        Espresso.onView(withId(R.id.tv_desc_det))
                .check(ViewAssertions.matches(withText(dummyTvShow[5].desc)))

        Espresso.pressBack()

    }
}