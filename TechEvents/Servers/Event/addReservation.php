<?php header('Access-Control-Allow-Origin: *'); ?>
<?php 
$idEvent=$_REQUEST['idEvent'];
$idUser=$_REQUEST['idUser'];

require_once('connect.php'); 
      $query_search = "insert into reservation (idEvent,idUser) values ($idEvent,$idUser) ;";  
      $stmt1 = $pdo->query($query_search, PDO::FETCH_OBJ);
?>
