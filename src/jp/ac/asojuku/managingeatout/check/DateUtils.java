package insyoku;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	/**
	 * 指定されたパターン文字列の文字列を Date オブジェクトにして返します。
	 * Date オブジェクトとして有効でない場合は null を返します。
	 *
	 * @param value 日付を表す文字列
	 * @param format 日付を表す文字列のパターン書式 (yyyy/MM/dd など)
	 * @return 日付を表す文字列の Date オブジェクト
	 */
	public static Date toDate(String value, String format) {

	    if ( value == null || value == "" )
	        return null;

	    if ( format == null || format == "" )
	        format = "yyyy/MM/dd";

	    // 日付フォーマットを作成
	    SimpleDateFormat dateFormat = new SimpleDateFormat(format);

	    // 日付の厳密チェックを指定
	    dateFormat.setLenient(false);

	    try {
	        // 日付値を返す
	        return dateFormat.parse(value);
	    } catch ( ParseException e ) {
	        // 日付値なしを返す
	        return null;
	    } finally {
	        dateFormat = null;
	    }
	}

	public static java.sql.Date toSQLDate(String value, String format) {

	    if ( value == null || value == "" )
	        return null;

	    if ( format == null || format == "" )
	        format = "yyyy/MM/dd";

	    // 日付フォーマットを作成
	    SimpleDateFormat dateFormat = new SimpleDateFormat(format);

	    // 日付の厳密チェックを指定
	    dateFormat.setLenient(false);

	    try {
	        // 日付値を返す
	        return (java.sql.Date)dateFormat.parse(value);
	    } catch ( ParseException e ) {
	        // 日付値なしを返す
	        return null;
	    } finally {
	        dateFormat = null;
	    }
	}

	/**
	 * 指定されたパターン文字列の文字列を Date オブジェクトにして返します。
	 * Date オブジェクトとして有効でない場合は null を返します。
	 *
	 * @param value 日付を表す文字列
	 * @return 日付を表す文字列の Date オブジェクト
	 */
	public static Date toDate(String value) {
	    return toDate(value , "yyyy/MM/dd");
	}

}