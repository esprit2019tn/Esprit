<?php header('Access-Control-Allow-Origin: *'); ?>
<?php 
$idEvent=$_REQUEST['idEvent'];
$titre=$_REQUEST['titre'];
$description=$_REQUEST['description'];
$capacitemax=$_REQUEST['capacitemax'];
$capacitemin=$_REQUEST['capacitemin'];
$duree=$_REQUEST['duree'];

require_once('connect.php'); 
      $query_search = "update evenement set titre = '$titre', description = '$description', capacitemax = $capacitemax ,
	  capacitemin = $capacitemin ,duree = $duree where idEvent = $idEvent ";
      $stmt1 = $pdo->query($query_search, PDO::FETCH_OBJ);
?>
