Page.onReady = function() {
    function updateIndianClock() {
        var now = new Date();
        var currdate = now;
        let session = "AM";
        var deadline = currdate.setHours(15, 29, 59);
        var countDownDate = new Date(deadline).getTime();
        var x = setInterval(function() {
            var now1 = new Date().getTime();
            var distance = deadline - now1;
            var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
            var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
            var seconds = Math.floor((distance % (1000 * 60)) / 1000);
            Page.Widgets.label21.caption = hours;
            Page.Widgets.label23.caption = minutes;
            Page.Widgets.label25.caption = seconds;
            if (distance < 0) {
                clearInterval(x);
            }
        }, 1000);
    }

    function updateAmericanClock() {
        var americaDateTime = new Date().toLocaleString("en-US", {
            timeZone: "America/New_York"
        });
        var currdate = americaDateTime;
        var deadline2 = currdate.setHours(15, 59, 59);
        var countDownDate2 = new Date(deadline2).getTime();
        var x = setInterval(function() {
            var now2 = new Date().toLocaleString("en-US", {
                timeZone: "America/New_York"
            }).getTime();
            var distance = deadline2 - now2;
            var hours2 = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
            var minutes2 = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
            var seconds2 = Math.floor((distance % (1000 * 60)) / 1000);
            Page.Widgets.label33.caption = hours2;
            Page.Widgets.label35.caption = minutes2;
            Page.Widgets.label37.caption = seconds2;
            if (distance < 0) {
                clearInterval(x);
            }
        }, 1000);
    }

    function updateIndianTime() {
        var dayNames = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
        var monthNames = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
        var now = new Date();
        var currdate = now;
        var hh = now.getHours();
        var mm = now.getMinutes();
        var ss = now.getSeconds();
        var day = now.getDay();
        var date = now.getDate();
        var month = now.getMonth();
        let session = "AM";
        var year = now.getYear() + 1900;
        Page.Widgets.label27.caption = date + 'th' + " " + monthNames[month] + " " + year + " " + dayNames[day];
        if (hh == 0) {
            hh = 12;
        }
        if (hh > 12) {
            hh = hh - 12;
            session = "PM";
        }

        hh = (hh < 10) ? "0" + hh : hh;
        mm = (mm < 10) ? "0" + mm : mm;
        ss = (ss < 10) ? "0" + ss : ss;

        let time = hh + ":" + mm + ":" + ss + " " + session;

        Page.Widgets.label31_1.caption = time;
        let t = setTimeout(function() {
            updateIndianTime()
        }, 1000);
    }

    function updateAmericanTime() {
        var americaDateTime = new Date().toLocaleString("en-US", {
            timeZone: "America/New_York"
        });
        americaDateTime = new Date(americaDateTime);
        var dayNames = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
        var monthNames = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
        var hh = americaDateTime.getHours();
        var mm = americaDateTime.getMinutes();
        var ss = americaDateTime.getSeconds();
        var day = americaDateTime.getDay();
        var date = americaDateTime.getDate();
        var month = americaDateTime.getMonth();
        let session = "AM";
        var year = americaDateTime.getYear() + 1900;
        Page.Widgets.label30.caption = date + 'th' + " " + monthNames[month] + " " + year + " " + dayNames[day];
        if (hh == 0) {
            hh = 12;
        }
        if (hh > 12) {
            hh = hh - 12;
            session = "PM";
        }

        hh = (hh < 10) ? "0" + hh : hh;
        mm = (mm < 10) ? "0" + mm : mm;
        ss = (ss < 10) ? "0" + ss : ss;

        let time = hh + ":" + mm + ":" + ss + " " + session;
        Page.Widgets.label31.caption = time;
        let t2 = setTimeout(function() {
            updateAmericanTime()
        }, 1000);
    }

    const apiKey = '20808422e1a9413ea17c13259c41230d';
    const apiUrl = `https://api.twelvedata.com/market_state?country=India&apikey=demo&source=docs&outputsize=50`;
    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            marketstatus = data[0]["is_market_open"];
            if (marketstatus == true) {
                Page.Widgets.linearlayout5_2.display = "flex";
                Page.Widgets.linearlayoutitem24.display = "flex";
                Page.Widgets.linearlayoutitem60_1.visibility = "hidden";
                updateIndianClock();
            } else {
                Page.Widgets.linearlayoutitem60_1.visibility = "visible";
                Page.Widgets.label29.caption = "Indian Stock Markets are closed for today come back later"
                Page.Widgets.linearlayout5_2.display = "none";
                Page.Widgets.linearlayoutitem24.display = "none";
            }
        })

    const apiUrl2 = `https://api.twelvedata.com/market_state?exchange=NYSE&apikey=demo&source=docs`;
    fetch(apiUrl2)
        .then(response => response.json())
        .then(data2 => {
            marketstatus2 = data2[0]["is_market_open"];
            if (marketstatus2 == true) {
                Page.Widgets.linearlayoutitem31.display = "flex";
                Page.Widgets.linearlayout19.display = "flex";
                Page.Widgets.linearlayoutitem45.visibility = "hidden";
                updateAmericanClock();
            } else {
                Page.Widgets.linearlayoutitem45.visibility = "visible";
                Page.Widgets.label39.caption = "American Stock Markets are closed for today come back later";
                Page.Widgets.linearlayoutitem31.display = "none";
                Page.Widgets.linearlayout19.display = "none";
            }
        })

    function updateNifty100() {
        const settings = {
            async: true,
            crossDomain: true,
            url: 'https://latest-stock-price.p.rapidapi.com/price?Indices=NIFTY%20100',
            method: 'GET',
            headers: {
                'X-RapidAPI-Key': '9bd2aa8d90msh89253751226ef58p127f9djsn29ed772c4dac',
                'X-RapidAPI-Host': 'latest-stock-price.p.rapidapi.com'
            }
        };

        $.ajax(settings).done(function(response) {
            var iStock1_symbol = JSON.stringify(response[85]["symbol"]);
            var iStock1_pChange = JSON.stringify(response[85]["pChange"]);
            var iStock1_price = JSON.stringify(response[85]["lastPrice"]);
            var iStock1_change = (response[85]["change"]).toFixed(2);

            var iStock2_symbol = JSON.stringify(response[20]["symbol"]);
            var iStock2_pChange = JSON.stringify(response[20]["pChange"]);
            var iStock2_price = JSON.stringify(response[20]["lastPrice"]);
            var iStock2_change = (response[20]["change"]).toFixed(2);

            var iStock3_symbol = JSON.stringify(response[42]["symbol"]);
            var iStock3_pChange = JSON.stringify(response[42]["pChange"]);
            var iStock3_price = JSON.stringify(response[42]["lastPrice"]);
            var iStock3_change = (response[42]["change"]).toFixed(2);

            Page.Widgets.label40.caption = iStock1_symbol.replace(/^"(.*)"$/, '$1');
            Page.Widgets.label41.caption = iStock1_price;
            Page.Widgets.label43.caption = iStock1_pChange;
            Page.Widgets.label45.caption = "(" + iStock1_change + ")";

            Page.Widgets.label46.caption = iStock2_symbol.replace(/^"(.*)"$/, '$1');;
            Page.Widgets.label47.caption = iStock2_price;
            Page.Widgets.label49.caption = iStock2_pChange;
            Page.Widgets.label51.caption = "(" + iStock2_change + ")";

            Page.Widgets.label52.caption = iStock3_symbol.replace(/^"(.*)"$/, '$1');;
            Page.Widgets.label53.caption = iStock3_price;
            Page.Widgets.label55.caption = iStock3_pChange;
            Page.Widgets.label57.caption = "(" + iStock3_change + ")";

            setTimeout(updateNifty100, 15000);
        });
    }

    updateNifty100();
    updateIndianTime();
    updateAmericanTime();
};
Page.label58Click = function($event, widget) {
    Page.Variables.americanTimeSeries100.invoke();
    Page.Variables.americanTimeSeries50.invoke();
    Page.Variables.americanTimeSeries25.invoke();
    Page.Variables.americanTimeSeries7.invoke();
    Page.Variables.americanTimeSeries100.setInput('symbol', 'AAPL');
    Page.Variables.americanTimeSeries50.setInput('symbol', 'AAPL');
    Page.Variables.americanTimeSeries25.setInput('symbol', 'AAPL');
    Page.Variables.americanTimeSeries7.setInput('symbol', 'AAPL');
};
Page.label64Click = function($event, widget) {
    Page.Variables.americanTimeSeries100.invoke();
    Page.Variables.americanTimeSeries50.invoke();
    Page.Variables.americanTimeSeries25.invoke();
    Page.Variables.americanTimeSeries7.invoke();
    Page.Variables.americanTimeSeries100.setInput('symbol', 'TSLA');
    Page.Variables.americanTimeSeries50.setInput('symbol', 'TSLA');
    Page.Variables.americanTimeSeries25.setInput('symbol', 'TSLA');
    Page.Variables.americanTimeSeries7.setInput('symbol', 'TSLA');
};
Page.label70Click = function($event, widget) {
    Page.Variables.americanTimeSeries100.invoke();
    Page.Variables.americanTimeSeries50.invoke();
    Page.Variables.americanTimeSeries25.invoke();
    Page.Variables.americanTimeSeries7.invoke();
    Page.Variables.americanTimeSeries100.setInput('symbol', 'MSFT');
    Page.Variables.americanTimeSeries50.setInput('symbol', 'MSFT');
    Page.Variables.americanTimeSeries25.setInput('symbol', 'MSFT');
    Page.Variables.americanTimeSeries7.setInput('symbol', 'MSFT');
};
Page.currency2Change = function($event, widget, newVal, oldVal) {
    var amount = newVal;
    const settings = {
        async: true,
        crossDomain: true,
        url: 'https://currency-converter-by-api-ninjas.p.rapidapi.com/v1/convertcurrency?have=USD&want=INR&amount=' + amount,
        method: 'GET',
        headers: {
            'X-RapidAPI-Key': '9bd2aa8d90msh89253751226ef58p127f9djsn29ed772c4dac',
            'X-RapidAPI-Host': 'currency-converter-by-api-ninjas.p.rapidapi.com'
        }
    };

    $.ajax(settings).done(function(response) {
        Page.Widgets.label88.caption = response["new_amount"] + " Rs";
    });
};
Page.currency2_1Change = function($event, widget, newVal, oldVal) {
    var amount2 = newVal;
    const settings = {
        async: true,
        crossDomain: true,
        url: 'https://currency-converter-by-api-ninjas.p.rapidapi.com/v1/convertcurrency?have=INR&want=USD&amount=' + amount2,
        method: 'GET',
        headers: {
            'X-RapidAPI-Key': '9bd2aa8d90msh89253751226ef58p127f9djsn29ed772c4dac',
            'X-RapidAPI-Host': 'currency-converter-by-api-ninjas.p.rapidapi.com'
        }
    };

    $.ajax(settings).done(function(response) {
        Page.Widgets.label73_1.caption = response["new_amount"] + " Dollars";
    });
};