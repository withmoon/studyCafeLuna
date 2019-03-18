package study.cafe.luna.ReserveTime.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.cafe.luna.ReserveTime.dao.ReserveTimeDAO;
import study.cafe.luna.ReserveTime.dto.ReserveTimeDTO;
import study.cafe.luna.ReserveTime.service.mgReserveTimeService;
 
@Service
public class mgReserveTimeServiceImpl implements mgReserveTimeService{
 
	@Autowired
	ReserveTimeDAO ReserveTimeDAO;
	
	
	@Override
	public List<ReserveTimeDTO> getreservcount(String paid_at_start, String paid_at_end, String branchName) {
		return ReserveTimeDAO.getreservcount(paid_at_start,paid_at_end,branchName);
	}
	//시간대별통계  
	@Override
	public List<ReserveTimeDTO> mgAgeList(String paid_at_start, String paid_at_end) {
		System.out.println("mgAgeList 서비스");
		return ReserveTimeDAO.mgAgeList(paid_at_start,paid_at_end);
	}
	//통계
	@Override
	public ReserveTimeDTO mgsu(List<ReserveTimeDTO> list,ReserveTimeDTO vo) {
		// TODO Auto-generated method stub 
		
		//배열	
		String[] array = null;
		
		
		int a00 = 0,a01 = 0,a02 = 0,a03 = 0,a04 = 0,a05 = 0;
		int a06 = 0,a07 = 0,a08 = 0,a09 = 0,a10 = 0,a11 = 0;
		int a12 = 0,a13 = 0,a14 = 0,a15 = 0,a16 = 0,a17 = 0;
		int a18 = 0,a19 = 0,a20 = 0,a21 = 0,a22 = 0,a23 = 0;
		
		System.out.println(list.toString());
		for(ReserveTimeDTO VOVO: list ) {
			System.out.println(VOVO.getReservetime());
			array = VOVO.getReservetime().split(",");
			for(String a : array) {
				System.out.print(a.toString().substring(0, 2)+" ");
//				if(a.toString().substring(0, 2).contains("20")) one += 1;
				switch(a.toString().substring(0, 2)) {
				 case "00" : a00+=1; break;   case "01" : a01+=1; break;
				 case "02" : a02+=1; break;   case "03" : a03+=1; break;
				 case "04" : a04+=1; break;   case "05" : a05+=1; break;
				 case "06" : a06+=1; break;   case "07" : a07+=1; break;
				 case "08" : a08+=1; break;   case "09" : a09+=1; break;
				 case "10" : a10+=1; break;   case "11" : a11+=1; break;
				 case "12" : a12+=1; break;   case "13" : a13+=1; break;
				 case "14" : a14+=1; break;   case "15" : a15+=1; break;
				 case "16" : a16+=1; break;   case "17" : a17+=1; break;
				 case "18" : a18+=1; break;   case "19" : a19+=1; break;
				 case "20" : a20+=1; break;   case "21" : a21+=1; break;
				 case "22" : a22+=1; break;   case "23" : a23+=1; break;
				 case "24" : a00+=1; break; 		 
				 //이게 무슨 노가다야...
				 default : break;
				 }
			} 
			System.out.println();
		}
		vo.setA00(a00); vo.setA01(a01); vo.setA02(a02); vo.setA03(a03); vo.setA04(a04); vo.setA05(a05);
		vo.setA06(a06); vo.setA07(a07); vo.setA08(a08); vo.setA09(a09); vo.setA10(a10); vo.setA11(a11);
		vo.setA12(a12); vo.setA13(a13); vo.setA14(a14); vo.setA15(a15); vo.setA16(a16); vo.setA17(a17);
		vo.setA18(a18); vo.setA19(a19); vo.setA20(a20); vo.setA21(a21); vo.setA22(a22); vo.setA23(a23);
		
	    vo.setAsum(a00+a01+a02+a03+a04+a05+a06+a07+a08+a09+a10+a11+a12+a13+a14+a15+a16+a17+a18+a19+a20+a21+a22+a23);
		
		System.out.print(" 00:"+vo.getA00()); 	System.out.print(" 01:"+vo.getA01());
		System.out.print(" 02:"+a02); 	System.out.print(" 03:"+a03);
		System.out.print(" 04:"+a04);	System.out.print(" 05:"+a05);
		System.out.print(" 06:"+a06);   System.out.print(" 07:"+a07);  
		System.out.print(" 08:"+a08);	System.out.print(" 09:"+a09);   
		System.out.print(" 10:"+a10);	System.out.print(" 11:"+a11);
		System.out.print(" 12:"+a12);
		System.out.print(" 13:"+a13);   System.out.print(" 14:"+a14);
		System.out.print(" 15:"+a15);   System.out.print(" 16:"+a16);
		System.out.print(" 17:"+a17);   System.out.print(" 18:"+a18);
		System.out.print(" 19:"+a19);   System.out.print(" 20:"+a20);
		System.out.print(" 21:"+a21);   System.out.print(" 22:"+a22);
		System.out.println(" 23:"+a23); 
		
		return vo;
		
	}
	
	
}
