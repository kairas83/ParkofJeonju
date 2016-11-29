<?
	// 데이터베이스 접속 문자열. (db위치, 유저 이름, 비밀번호)
    $connect=mysql_connect( "home35.ipdisk.co.kr", "msd", "msd") or  
		die( "SQL server에 연결할 수 없습니다.");
 
    
    mysql_query("SET NAMES UTF8");
	// 데이터베이스 선택
	mysql_select_db("msd", $connect);
 
	// 세션 시작
	session_start();
	
	// 쿼리문 생성
	$sql = "select * from 공원정보";
 
	// 쿼리 실행 결과를 $result에 저장
	$result = mysql_query($sql, $connect);
	// 반환된 전체 레코드 수 저장.
	$total_record = mysql_num_rows($result);
	
	// JSONArray 형식으로 만들기 위해서...
	echo "{\"status\":\"OK\",\"num_results\":\"$total_record\",\"results\":[";
 
	// 반환된 각 레코드별로 JSONArray 형식으로 만들기.
	for ($i=0; $i < $total_record; $i++)                    
	{
		// 가져올 레코드로 위치(포인터) 이동  
		mysql_data_seek($result, $i);       
        
		$row = mysql_fetch_array($result);
		echo "{\"이름\":\"$row[이름]\",
		\"구분\":\"$row[구분]\",
		\"구\":\"$row[구]\",
		\"세부주소\":\"$row[세부주소]\",
		\"위도\":\"$row[위도]\",
		\"경도\":\"$row[경도]\",
		\"면적\":\"$row[면적]\",
		\"연락처\":\"$row[연락처]\",
		\"parkimg_name\":\"$row[parkimg_name]\"}";
 
		// 마지막 레코드 이전엔 ,를 붙인다. 그래야 데이터 구분이 되니깐.  
		if($i<$total_record-1){
			echo ",";
		}
    
	}
   // JSONArray의 마지막 닫기
   echo "]}";
?>