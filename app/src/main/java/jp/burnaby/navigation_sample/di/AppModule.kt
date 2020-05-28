package jp.burnaby.navigation_sample.di

import dagger.Module


@Module(
    includes = [
        ViewModelModule::class
    ]
)
internal class AppModule {

//    @Singleton
//    @Provides
//    fun provideSharedPreference(context: Context): SharedPreferences {
//        return PreferenceManager.getDefaultSharedPreferences(context.applicationContext)
//    }
//
//    @Singleton
//    @Provides
//    fun provideOkHttpClient(): OkHttpClient {
//        val logging = HttpLoggingInterceptor()
//        logging.level = HttpLoggingInterceptor.Level.BODY
//
//        val httpBuilder = OkHttpClient.Builder()
//            .addInterceptor(Interceptor { chain ->
//                val original = chain.request()
//                val request = original.newBuilder()
//                    .header("Accept", "application/json")
//                    .header("X-Authentication-agLife", BuildConfig.AUTH_KEY_AGLIFE)
//                    .method(original.method, original.body)
//                    .build()
//
//                return@Interceptor chain.proceed(request)
//
//            })
//        if (BuildConfig.DEBUG) {
//            httpBuilder.addInterceptor(logging)
//        }
//        return httpBuilder.build()
//    }
//
//    @Singleton
//    @Provides
//    fun provideAgLifeService(okHttpClient: OkHttpClient): AgLifeService {
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BuildConfig.URL_BASE_AGLIFE)
//            .addConverterFactory(MoshiConverterFactory.create())
//            .client(okHttpClient)
//            .build()
//        return retrofit.create(AgLifeService::class.java)
//    }

}
