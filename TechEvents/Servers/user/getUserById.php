<?php header('Access-Control-Allow-Origin: *'); ?>
<?php 
$idUser=$_REQUEST['idUser'];
require_once('..\connect.php');
      $query_search = "SELECT * FROM user where idUser='".$idUser."'";  
      $jsontext = "[";
      $stmt1 = $pdo->query($query_search, PDO::FETCH_OBJ);
			foreach($stmt1->fetchAll() as $row) {
				$jsontext .="{";
				foreach($row as $key => $value) {
	    			$jsontext .= '"'.addslashes($key).'": "'.addslashes($value).'",';
					}
					$jsontext = substr_replace($jsontext, '', -1);
					$jsontext .="},";
	}
	$jsontext = substr_replace($jsontext, '', -1);
	$jsontext .= "]";
	echo $jsontext;
	//echo $query_search;
?>
