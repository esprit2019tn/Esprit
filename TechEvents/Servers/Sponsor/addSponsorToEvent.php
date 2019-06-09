<?php header('Access-Control-Allow-Origin: *'); ?>
<?php 
$idevent=$_REQUEST['idevent'];
$idsponsor=$_REQUEST['idsponsor'];

require_once('..\connect.php'); 
      $query_search = "insert into sponsorevent  (idSponsor,idEvent) 
	  VALUES ($idsponsor, $idevent) ";  
      $stmt1 = $pdo->query($query_search, PDO::FETCH_OBJ);
?>
