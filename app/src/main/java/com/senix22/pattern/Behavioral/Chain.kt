package com.senix22.pattern.Behavioral

abstract class DataSource() {
    private var nextDataSource: DataSource? = null
    fun linkWith(next: DataSource): DataSource {
        nextDataSource = next
        return next
    }
    abstract fun getData(): Int
    protected fun checkNext(): Int {
        return if (nextDataSource == null) {
            0
        } else {
            nextDataSource!!.getData()
        }
    }
}
class RemoteDataSource(private val retrofitService: RetrofitService) : DataSource() {
    override fun getData(): Int {
        val data = retrofitService.getData()
        return if (data.isNotEmpty()) {
            2
        } else {
            checkNext()
        }
    }
}
class LocalDataSource() : DataSource() {
    override fun getData(): Int {
        return if (localStoredData.isNotEmpty()) {
            5
        } else {
            checkNext()
        }
    }
}
const val localStoredData = "AS"
class CacheDataSource() : DataSource() {
    private val data = "CacheDataSource"
    override fun getData(): Int {
        return if (data.isNotEmpty()) {
            10
        } else {
            checkNext()
        }
    }
}
class GeneralStorage() {
    private var dataSource: DataSource? = null
    fun setDataSource(dataSource: DataSource) {
        this.dataSource = dataSource
    }
    fun getData(): Int? {
        return dataSource?.getData()
    }
}
class RetrofitService() {
    fun getData() = "Data from retrofit"
}
fun main() {
    val generalStorage = GeneralStorage()
    val cacheDataSource = CacheDataSource()
    cacheDataSource.linkWith(LocalDataSource()).linkWith(RemoteDataSource(RetrofitService()))
    generalStorage.setDataSource(cacheDataSource)
    println(generalStorage.getData())
}