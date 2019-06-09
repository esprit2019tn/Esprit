<?php header('Access-Control-Allow-Origin: *'); ?>
<?php 
$iduser=$_REQUEST['iduser'];
$idevent=$_REQUEST['idevent'];

require_once('connect.php'); 
      $query_search = "insert into reservation  (idUser,idevent) 
	  VALUES ($iduser, $idevent) ";  
      $stmt1 = $pdo->query($query_search, PDO::FETCH_OBJ);
?>
