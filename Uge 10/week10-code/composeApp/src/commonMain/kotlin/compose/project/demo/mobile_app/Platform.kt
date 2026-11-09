package compose.project.demo.mobile_app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform