$(document).ready(function() {
updateTable();
});

function updateTable()
{
    var txt = "";
        $.ajax({
            type: "GET",
            contentType: "application/json; charset=utf-8",
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

            document.getElementById("tb").innerHTML = txt;
        });
}

function add()
{
    let value = document.getElementById('text').value;
    let obj = `{"text": "${value}"}`;
    let json = JSON.parse(obj);

    $.ajax({
      type: "POST",
      url: '/api/texts',
      data: obj,
      contentType: "application/json; charset=utf-8"
    }).then(function(){
        updateTable();
    });
}