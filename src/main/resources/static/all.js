$(document).ready(function() {
updateTable();
});

$(document).on('click', '.del', deleteID);


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
                console.log(text + " " + id);
                txt += "<tr><td>" + id + "</td>";
                txt += "<td>" + text +"</td>";
                txt += "<td><button class='del'  id='b" + id +"'>&#10005</button></td";
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


function deleteID(event)
{
    console.log(this);

    console.log(this.id.substring(1));
    let id = this.id.substring(1);

    console.log(id);

    $.ajax({
          type: "DELETE",
          url: '/api/texts/' + id,
          contentType: "application/json; charset=utf-8"
        }).then(function(){
            updateTable();
        });

}