package study.cafe.luna.util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import study.cafe.luna.Reserve.dto.ReserveDTO;

public class listExcelDownload extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> modelMap, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String sCurTime = null; 
		sCurTime = new SimpleDateFormat("yyyyMMdd", Locale.KOREA).format(new Date());

		String excelName = sCurTime + "_달빛엑셀다운로드.xlsx";
		Sheet worksheet = null;
		Row row = null;
		CellStyle style = workbook.createCellStyle(); /// 셀 스타일을 위한 변수
		// style.setAlignment(CellStyle.ALIGN_CENTER); // 글 위치를 중앙으로 설정
		
		CellStyle style1 = workbook.createCellStyle(); /// 셀 스타일을 위한 변수
		style1.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);  
		style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		
		
		List<ReserveDTO> listExcel = (List<ReserveDTO>) modelMap.get("list");
		String name = (String) modelMap.get("branchName");
		// 새로운 sheet를 생성한다.
		worksheet = workbook.createSheet("엑셀 목록");

		// 가장 첫번째 줄에 제목을 만든다.
		row = worksheet.createRow(0);

		// 칼럼 길이 설정
		int columnIndex = 0;
		while (columnIndex < 7) {

			if (columnIndex == 0) {
				worksheet.setColumnWidth(columnIndex, 3000);
			} else if (columnIndex == 1) {
				worksheet.setColumnWidth(columnIndex, 4000);
			} else if (columnIndex == 2) {
				worksheet.setColumnWidth(columnIndex, 6000);
			} else if (columnIndex == 3) {
				worksheet.setColumnWidth(columnIndex, 4000);
			} else if (columnIndex == 4) {
				worksheet.setColumnWidth(columnIndex, 7000);
			} else if (columnIndex == 5) {
				worksheet.setColumnWidth(columnIndex, 3000);
			} else if (columnIndex == 6) {
				worksheet.setColumnWidth(columnIndex, 3000);
			}
			columnIndex++;
		}
		//Cell cell = row.createCell(0);
		//cell.setCellStyle(style1);
		
		// 헤더 설정
		row = worksheet.createRow(0);
		row.createCell(0).setCellValue("날짜");
		row.createCell(1).setCellValue("예약수");
		row.createCell(2).setCellValue("금액");
		row.createCell(3).setCellValue("환불횟수");
		int rowIndex = 1;
		int total = 0; 
		// 각 해당하는 셀에 값과 스타일을 넣음
		for(int i=0; i<4; i++) {
			row.getCell(i).setCellStyle(style1);
		}
		
		
		for (ReserveDTO board : listExcel) {
			row = worksheet.createRow(rowIndex);
			row.createCell(0).setCellValue(board.getReservdate());
			row.createCell(1).setCellValue(board.getGunsu());
			row.createCell(2).setCellValue(board.getTotal());
			row.createCell(3).setCellValue(board.getStatus());
			total+=board.getTotal();
			name= board.getBranchName();
			rowIndex++;
		}

		// 셀 병합 CellRangeAddress(시작 행, 끝 행, 시작 열, 끝 열)
//		worksheet.addMergedRegion(new CellRangeAddress(listExcel.size() + 1, listExcel.size() + 1, 0, 6));

		// 병합 테스트를 위한 설정
		row = worksheet.createRow(listExcel.size() + 1);
		row.createCell(0).setCellValue("총합 :");
		row.createCell(1).setCellValue(total);
		row.createCell(2).setCellValue("");
		row.createCell(3).setCellValue("");
		for(int i=0; i<4; i++) {
			row.getCell(i).setCellStyle(style1);
		}
		
		//row.getCell(0).setCellStyle(style1); // 지정한 스타일을 입혀준다.
		//cell.setCellStyle(style1);
		try {
			response.setHeader("Content-Disposition", "attachement; filename=\""
					+ java.net.URLEncoder.encode(excelName, "UTF-8") + "\";charset=\"UTF-8\"");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
