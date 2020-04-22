package xueqiu.testCase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;
import xueqiu.PO.SearchPage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;

public class SearchPageTest {
    static SearchPage searchPage;

    @BeforeAll
    public static void setUp() {
        searchPage = new SearchPage();
    }

    @ParameterizedTest
    @ValueSource(strings = {"PDD", "张江高科", "威孚高科", "依顿电子"})
    public void testSerach(String stock) {
        System.out.println(stock);
        searchPage.searchClick(stock);
        assertThat("判定是否查找到股票", searchPage.elementExist("//*[@text='" + stock + "']"));
    }

    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    public void testSearchClickStock(String stock) {
        searchPage.serchClickStock(stock);
        assertThat("判定是否进入股票详情页", searchPage.elementExist("//*[@text='交易']"));
        searchPage.back();
    }

    @Test
    public void test() {
        searchPage.back();
    }
}

class MyArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        //Arguments::of 是lambda表达式
        return Stream.of("PDD", "张江高科", "威孚高科", "依顿电子").map(Arguments::of);
    }
}
