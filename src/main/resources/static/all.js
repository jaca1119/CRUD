$(document).ready(function() {
var txt = "";
    $.ajax({
        url: "http://localhost:8080/api/texts"
    }).then(function(data) {

        for (let i = 0; i < data.length; i++)
        {
            let id = data[i].id;
            let text = data[i].text;
            console.log(text);
            txt += "<tr><td>" + id + "</td>";
            txt += "<td>" + text +"</td>"
            txt += "</tr>";
        }

        document.getElementById("table").innerHTML += txt;
    });
});