package CurvasHorizontales

class CurvasCircular (D:Double,C:Double,Ra:Double) {

    // Formulas para calcular elementos de las curvas, sacadas del manual de invias

    val T = Ra * Math.tan((D / 2) * Math.PI / 180)
    var CL = 2 * Ra * Math.sin((D / 2) * Math.PI / 180)
    var E = T * Math.tan((D / 4) * Math.PI / 180)
    var O = Ra * (1 - Math.cos((D / 2) * Math.PI / 180))
    var Gr = (2 * (Math.asin(C / (2 * Ra)))) * 180 / Math.PI
    var L = (Ra * D * Math.PI) / 180
    var Cu = Gr / (2 * C)
    var Dm = Gr / 2
}