import com.liferay.portal.kernel.service.UserLocalServiceUtil
import com.liferay.portal.kernel.dao.orm.QueryUtil

// Get all users
def users = UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS)

int updatedCount = 0

users.each { user ->
    
    if (user.languageId != "ar_DZ") {
        
        user.setLanguageId("ar_DZ")
        UserLocalServiceUtil.updateUser(user)
        
        println("Updated user: " + user.getEmailAddress())
        updatedCount++
    }
}

println("=================================")
println("Total users updated: " + updatedCount)
println("Done.")