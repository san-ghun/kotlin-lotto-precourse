package lotto

// TODO: convert to general class only to encapsulate and process list of 'Lotto'
// There is no need for this class to be a data class.
data class LottoBundle(val tickets: List<Lotto>)