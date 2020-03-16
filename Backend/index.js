const mysql = require("mysql");
const express = require("express");
var app = express();
const bodyparser = require("body-parser");

app.use(bodyparser.json());

var mysqlConnection = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "",
  database: "abmlab4"
});

mysqlConnection.connect(err => {
  if (!err) {
    console.log("Base de data conectada eeeeee");
  } else {
    console.log(
      "No flaco algo mal hiciste, no se conecto la bd. Paso esto: " +
        JSON.stringify(err, undefined, 2)
    );
  }
});

app.listen(3000, () => {
  console.log("Servidor de express levantado en puerto 3000");
});

//get all empresa
app.get("/empresa", (req, res) =>
  mysqlConnection.query("SELECT * FROM Empresa", (err, rows, fields) => {
    if (!err) {
      res.send(rows);
    } else {
      console.log(err);
    }
  })
);

//get one empresa
app.get("/empresa/:id", (req, res) =>
  mysqlConnection.query(
    "SELECT * FROM Empresa WHERE id = ?",
    [req.params.id],
    (err, rows, fields) => {
      if (!err) {
        res.send(rows);
      } else {
        console.log(err);
      }
    }
  )
);

//delete empresa
app.delete("/empresa/:id", (req, res) =>
  mysqlConnection.query(
    "DELETE * FROM Empresa WHERE id = ?",
    [req.params.id],
    (err, rows, fields) => {
      if (!err) {
        res.send("Se elimino correctamente");
      } else {
        console.log(err);
      }
    }
  )
);

//post empresa
app.delete("/empresa", (req, res) => {
  let emp = req.body;
  var sql =
    "SET @id = ?; SET @denominacion = ?; SET @telefono = ?; SET @horario = ?; SET @info = ?; SET @latitud = ?; SET @longitud = ?; SET @domicilio= ?; SET @email = ?; \
  CALL posteditempresa(@id,@denominacion,@telefono,@horario,@info,@latitud,@longitud,@longitud,@domicilio,@email);";
  mysqlConnection.query(
    sql,
    [
      emp.id,
      emp.denominacion,
      emp.telefono,
      emp.horario,
      emp.info,
      emp.latitud,
      emp.longitud,
      emp.domicilio,
      emp.email
    ],
    [req.params.id],
    (err, rows, fields) => {
      if (!err) {
        rows.forEach(element => {
          if (element.constructor == Array) {
            res.send("Nueva empresa. ID: " + emelement[0].id);
          }
        });
      } else {
        console.log(err);
      }
    }
  );
});

//update empresa
app.delete("/empresa", (req, res) => {
  let emp = req.body;
  var sql =
    "SET @id = ?; SET @denominacion = ?; SET @telefono = ?; SET @horario = ?; SET @info = ?; SET @latitud = ?; SET @longitud = ?; SET @domicilio= ?; SET @email = ?; \
  CALL posteditempresa(@id,@denominacion,@telefono,@horario,@info,@latitud,@longitud,@longitud,@domicilio,@email);";
  mysqlConnection.query(
    sql,
    [
      emp.id,
      emp.denominacion,
      emp.telefono,
      emp.horario,
      emp.info,
      emp.latitud,
      emp.longitud,
      emp.domicilio,
      emp.email
    ],
    [req.params.id],
    (err, rows, fields) => {
      if (!err) {
        res.send("Empresa actualizada");
      } else {
        console.log(err);
      }
    }
  );
});
