package no.uia.ikt205.pomodoro.util

fun millisecondsToDescriptiveTime(ms:Long):String {
    val seconds = (ms / 1000)  % 60
    val minutes = (ms / (1000 * 60) % 60)
    val hours = (ms / (1000 * 60 * 60) % 24)

    return String.format("%02d:%02d:%02d", hours, minutes, seconds);
}

fun minutesToMilliSeconds(minutes:Long):Long{
    return minutes * 60000
}
//for testing with seconds instead of minutes
fun secondsToMilliSeconds(seconds:Long):Long{
    return seconds*1000
}