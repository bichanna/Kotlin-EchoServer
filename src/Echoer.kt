import java.net.Socket
import java.io.*

class Echoer(private val socket: Socket): Thread() {

    override fun run() {
        try {
            val input = BufferedReader(InputStreamReader(socket.getInputStream()))
            val output = PrintWriter(socket.getOutputStream(), true)
            while (true) {
                val echoString: String = input.readLine()
                println("Received client input: $echoString")
                if (echoString == "exit") {
                    println("Client disconnected")
                    break
                }
                output.println(echoString)
            }
        } catch (e: IOException) {
            println("Error occurred: ${e.localizedMessage}")
        } finally {
            try {
                socket.close()
            } catch (ignored: IOException) {}
        }
    }
}