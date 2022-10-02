package ua.cn.stu.http.sources.boxes

import kotlinx.coroutines.delay
import ua.cn.stu.http.app.model.boxes.BoxesSource
import ua.cn.stu.http.app.model.boxes.entities.BoxAndSettings
import ua.cn.stu.http.app.model.boxes.entities.BoxesFilter
import ua.cn.stu.http.sources.base.BaseRetrofitSource
import ua.cn.stu.http.sources.base.RetrofitConfig
import ua.cn.stu.http.sources.boxes.entities.UpdateBoxRequestEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitBoxesSource @Inject constructor(
    config: RetrofitConfig
) : BaseRetrofitSource(config), BoxesSource {

    val boxesApi = retrofit.create(BoxesApi::class.java)

    override suspend fun setIsActive(
        boxId: Long,
        isActive: Boolean
    )  = wrapRetrofitExceptions{
        val updateBoxRequestEntity = UpdateBoxRequestEntity(
            isActive = isActive
        )
        boxesApi.setActive(boxId,updateBoxRequestEntity)
    }

    override suspend fun getBoxes(
        boxesFilter: BoxesFilter
    ): List<BoxAndSettings> = wrapRetrofitExceptions {
        delay(500)
        val isActive: Boolean? = if (boxesFilter == BoxesFilter.ONLY_ACTIVE)
            true
        else
            null

        boxesApi.getBoxes(isActive).map { it.toBoxAndSettings() }
    }

}