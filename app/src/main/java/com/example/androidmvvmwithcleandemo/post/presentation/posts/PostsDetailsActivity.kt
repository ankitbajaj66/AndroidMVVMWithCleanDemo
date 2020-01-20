package com.example.androidmvvmwithcleandemo.post.presentation.posts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.androidmvvmwithcleandemo.R
import com.example.androidmvvmwithcleandemo.post.data.api.Api
import com.example.androidmvvmwithcleandemo.post.data.mappers.PostDataEntityMapper
import com.example.androidmvvmwithcleandemo.post.data.repositories.CachedDataSourceImpl
import com.example.androidmvvmwithcleandemo.post.data.repositories.NetworkDataSourceImpl
import com.example.androidmvvmwithcleandemo.post.data.repositories.PostRepositoryImpl
import com.example.androidmvvmwithcleandemo.post.domain.PostRepository
import com.example.androidmvvmwithcleandemo.post.domain.entity.PostEntity
import com.example.androidmvvmwithcleandemo.post.domain.usecase.GetPosts
import com.example.androidmvvmwithcleandemo.post.presentation.common.AsyncTransformer
import com.example.androidmvvmwithcleandemo.post.presentation.mappers.PostEntityPostMapper
import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_posts_details.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PostsDetailsActivity : AppCompatActivity() {

    private lateinit var viewModel: PostsDetailsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts_details)


        // Network Data Source
        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
            .addCallAdapterFactory(
                RxJava2CallAdapterFactory.create()
            ).addConverterFactory(GsonConverterFactory.create()).build()

        val networkDataSource =
            NetworkDataSourceImpl(retrofit.create(Api::class.java), PostDataEntityMapper())

        // Cache data source
        val cachedDataSource = CachedDataSourceImpl()

        // Repository
        val repo = PostRepositoryImpl.getInstance(networkDataSource, cachedDataSource)

        // Transformer
        val asyncTransformer = AsyncTransformer<List<PostEntity>>()

        // Usecase
        val getPosts = GetPosts(asyncTransformer, repo)

        val postEntityPostMapper = PostEntityPostMapper()

        viewModel = ViewModelProviders.of(
            this,
            PostsDetailsViewModelFactory(getPosts, postEntityPostMapper)
        ).get(PostsDetailsViewModel::class.java)

        viewModel.viewState.observe(this, Observer {

            if (it != null) {
                if (!it.isLoading && !it.isEmpty) {
                    // posts.text = it.posts?.size.toString()
                    val stringBuffer = StringBuffer()
                    it.posts?.forEach {
                        stringBuffer.append(" " + it.userId)
                    }
                    posts.text = stringBuffer.toString()
                } else {
                    posts.text = "Error"
                }

            }
        })

        btn_get_posts.setOnClickListener {
            viewModel.getPosts()
        }
    }
}
