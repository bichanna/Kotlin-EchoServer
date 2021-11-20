import java.net.ServerSocket
import java.net.Socket

fun main() {
    ServerSocket(6000).use { serverSocket ->
        while (true) {
            val socket: Socket = serverSocket.accept()
            Echoer(socket).start()
        }
    }
}