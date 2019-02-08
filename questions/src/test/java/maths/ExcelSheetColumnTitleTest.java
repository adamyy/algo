package maths;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class ExcelSheetColumnTitleTest {

  @Test
  public void convertToTitle() {
    assertThat(ExcelSheetColumnTitle.convertToTitle(1)).isEqualTo("A");
    assertThat(ExcelSheetColumnTitle.convertToTitle(28)).isEqualTo("AB");
    assertThat(ExcelSheetColumnTitle.convertToTitle(701)).isEqualTo("ZY");
  }
}