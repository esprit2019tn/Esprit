<?php header('Access-Control-Allow-Origin: *'); ?>
<?php 
$idevent=$_REQUEST['idevent'];

require_once('..\connect.php'); 
      $query_search = "delete from sponsorevent  where idEvent = $idevent ";  
      $stmt1 = $pdo->query($query_search, PDO::FETCH_OBJ);
?>
