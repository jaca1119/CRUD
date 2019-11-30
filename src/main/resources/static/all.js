$(document).ready(function() {
updateTable();
});

$(document).on('click', '.del', deleteID);
$(document).on('click', '.update', updateID);


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
                txt += "<tr><td>" + id + "</td>";
                txt += "<td>" + text +"</td>";
                txt += "<td><button class='update'  id='u" + id +"'>Update</button></td>";
                txt += "<td><button class='del'  id='b" + id +"'>&#10005</button></td>";
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
    let id = this.id.substring(1);

    $.ajax({
          type: "DELETE",
          url: '/api/texts/' + id,
          contentType: "application/json; charset=utf-8"
        }).then(function(){
            updateTable();
        });
}

function updateID(event)
{
    let id = this.id.substring(1);
    let text = this.parentNode.parentNode.cells[1].innerText

    let txt = "<p>ID: " + id +"</p>";
    txt += "<input type='text' value=" + text + ">";
    txt += "<button onclick=\"closeWindow()\">&#10005</button>";

    document.getElementsByClassName("modal")[0].innerHTML = txt;

    showWindow();
}

function showWindow()
{
    document.getElementsByClassName("overlay")[0].style.display = "block";
}

function closeWindow()
{
    document.getElementsByClassName("overlay")[0].style.display = "none";
}