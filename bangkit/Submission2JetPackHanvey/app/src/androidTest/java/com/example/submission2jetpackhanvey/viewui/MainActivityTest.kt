package com.example.submission2jetpackhanvey.viewui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.example.submission2jetpackhanvey.R
import com.example.submission2jetpackhanvey.utility.EspressoIdlingResource
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * * Instrumentation testing:
- memastikan carouselView muncul

menampilkan data movie dan data TvShow
- memastikan movieRv muncul
- scroll movieRv sampai item terakhir
- menekan navigation dengan id navigation_tv
- memastikan tvShowRv muncul
- scroll tvShowRv sampai item terakhir

menampilkan data detail movie
- melakukan scroll movieRv ke data ke 5 dan melakukan action klik
- memastikan img_item_photo muncul
- memastikan img_full muncul
- memastikan tv_title_det muncul
- memastikan tv_desc_det muncul
- memastikan tv_genre muncul
- memastikan tv_release_date muncul
- menekan tombol kembali

menampilkan data detail tvShow
- menekan navigation dengan id navigation_tv
- melakukan scroll tvShowRv ke data ke 5 dan melakukan action klik
- memastikan img_item_photo muncul
- memastikan img_full muncul
- memastikan tv_title_det muncul
- memastikan tv_desc_det muncul
- memastikan tv_genre muncul
- memastikan tv_release_date muncul
- menekan tombol kembali
 */
class MainActivityTest {

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun loadCarouselList() {
        Espresso.onView(withId(R.id.carouselView)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun loadMovieAndTvShow() {
        Espresso.onView(withId(R.id.movieRv)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.movieRv))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
        Espresso.onView(withId(R.id.navigation_tv)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.tvShowRv)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tvShowRv))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
        Espresso.pressBack()
    }

    @Test
    fun detailMovie() {
        Espresso.onView(withId(R.id.movieRv))
                .perform(
                        RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                                5,
                                ViewActions.click()
                        )
                )
        Espresso.onView(withId(R.id.tv_title_det))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_genre))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_release_date))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_desc_det))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.img_full))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.img_item_photo))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.pressBack()
    }

    @Test
    fun detailTvShow() {
        Espresso.onView(withId(R.id.navigation_tv)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.tvShowRv)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tvShowRv))
                .perform(
                        RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                                5,
                                ViewActions.click()
                        )
                )
        Espresso.onView(withId(R.id.tv_title_det))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_genre))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_release_date))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_desc_det))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.img_full))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.img_item_photo))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.pressBack()
    }
}