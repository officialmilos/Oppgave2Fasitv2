$(function (){ //Kalles når siden er lastet

    //Henter valutaer fra serveren
    $.post("/getCurrencies", function(data){
        let ut = "<label for='currency'>Skriv inn en valuta</label><select id='currency'>"
        for(let currency of data){
            ut += "<option value='" + currency.currency + "'>" + currency.currency + "</option>"
        }
        ut += "</select>"
        $("#currencySelect").html(ut)
    })
})

$("#convert").click(function (){
    let currencyValue = {
        currency: $("#currency").val(),
        amount: $("#amount").val()
    }
    // Sjekker om brukeren har skrevet inn et tall større enn 0 i inputfeltet så sendes det til serveren
    if(currencyValue.amount > 0){
        $.post("/calculateValue", currencyValue, function(data){
            if(data !== 0){
                let ut = "<p>"+ currencyValue.amount + " " + currencyValue.currency + " er " + data + " NOK</p>"
                $("#result2").html(ut)
            }
            else{
                $("#result2").html("Det skjedde noe feil på serveren")
            }
        })
    }
})