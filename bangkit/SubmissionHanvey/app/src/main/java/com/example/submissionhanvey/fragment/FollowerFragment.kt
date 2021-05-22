package com.example.submissionhanvey.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionhanvey.R
import com.example.submissionhanvey.pageadapter.FollowerAdapter
import com.example.submissionhanvey.pageadapter.UserAdapter
import com.example.submissionhanvey.databinding.FragmentFollowerBinding
import com.example.submissionhanvey.DataUsers
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray
import org.json.JSONObject


class FollowerFragment : Fragment() {
    private var listDetail: ArrayList<DataUsers> = ArrayList()
    private lateinit var binding: FragmentFollowerBinding
    private lateinit var adapter: FollowerAdapter

    private fun showFollower() {
        binding.listFollower.layoutManager = LinearLayoutManager(activity)
        val detailAdapter = UserAdapter(listDetail)
        binding.listFollower.adapter = adapter

        detailAdapter.setSelectUser(object : UserAdapter.SelectUser {
            override fun onSelectedUser(data: DataUsers) {}
        })
    }

    private fun getUserInfo(id: String) {
        val client = AsyncHttpClient()
        val url = "https://api.github.com/users/$id"
        binding.loadingFollower.visibility = View.VISIBLE
        client.addHeader("Authorization", "token 6a989c182c40e1b51e3a9fd290845ba81c45bd40")
        client.addHeader("User-Agent", "request")
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray
            ) {
                binding.loadingFollower.visibility = View.INVISIBLE
                val result = String(responseBody)
                Log.d(TAG, result)
                try {
                    val jsonObject = JSONObject(result)
                    val id = jsonObject.getInt("id")
                    val avatar = jsonObject.getString("avatar_url").toString()
                    val name = jsonObject.getString("name").toString()
                    val username = jsonObject.getString("login").toString()
                    val repository = jsonObject.getString("public_repos")
                    val company = jsonObject.getString("company").toString()
                    val location = jsonObject.getString("location").toString()
                    val followers = jsonObject.getString("followers")
                    val following = jsonObject.getString("following")
                    listDetail.add(
                        DataUsers(
                            id,
                            avatar,
                            name,
                            username,
                            repository,
                            company,
                            location,
                            followers,
                            following
                        )
                    )
                    showFollower()
                } catch (err: Exception) {
                    Toast.makeText(activity, err.message, Toast.LENGTH_SHORT).show()
                    err.printStackTrace()
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                binding.loadingFollower.visibility = View.INVISIBLE
                val errMessage = when (statusCode) {
                    401 -> "$statusCode: Unauthorized"
                    403 -> "$statusCode: Forbidden"
                    404 -> "$statusCode: Not Found"
                    500 -> "$statusCode: Internal Server Error"
                    502 -> "$statusCode: Bad Gateway"
                    503 -> "$statusCode: Service Unavailable"
                    else -> "$statusCode: ${error?.message}"
                }
                Toast.makeText(activity, errMessage, Toast.LENGTH_LONG).show()
            }
        })

    }

    private fun getFollower(id: String) {
        val client = AsyncHttpClient()
        val url = "https://api.github.com/users/$id/followers"
        binding.loadingFollower.visibility = View.VISIBLE
        client.addHeader("Authorization", "token 6a989c182c40e1b51e3a9fd290845ba81c45bd40")
        client.addHeader("User-Agent", "request")
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray
            ) {
                binding.loadingFollower.visibility = View.INVISIBLE
                val result = String(responseBody)
                Log.d(TAG, result)
                try {
                    binding.listFollower.visibility = View.VISIBLE
                    val jsonArray = JSONArray(result)
                    if (jsonArray.length() == 0) {
                        binding.listFollower.visibility = View.INVISIBLE
                        Toast.makeText(activity, R.string.no_follower, Toast.LENGTH_SHORT).show()
                    } else {
                        binding.listFollower.visibility = View.VISIBLE
                        for (i in 0 until jsonArray.length()) {
                            val jsonObject = jsonArray.getJSONObject(i)
                            val username: String = jsonObject.getString("login")
                            getUserInfo(username)
                        }
                    }
                } catch (err: Exception) {
                    Toast.makeText(activity, err.message, Toast.LENGTH_SHORT).show()
                    err.printStackTrace()
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                binding.loadingFollower.visibility = View.INVISIBLE
                binding.listFollower.visibility = View.GONE
                val errMessage = when (statusCode) {
                    401 -> "$statusCode: Unauthorized"
                    403 -> "$statusCode: Forbidden"
                    404 -> "$statusCode: Not Found"
                    500 -> "$statusCode: Internal Server Error"
                    502 -> "$statusCode: Bad Gateway"
                    503 -> "$statusCode: Service Unavailable"
                    else -> "$statusCode: ${error?.message}"
                }
                Toast.makeText(activity, errMessage, Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFollowerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = FollowerAdapter(listDetail)
        listDetail.clear()
        val userDetail = activity?.intent?.getParcelableExtra<DataUsers>(EXTRA_DETAIL) as DataUsers
        getFollower(userDetail.username.toString())
    }

    companion object {
        private val TAG = FollowerFragment::class.java.simpleName
        val EXTRA_DETAIL = "extra_detail"
    }

}