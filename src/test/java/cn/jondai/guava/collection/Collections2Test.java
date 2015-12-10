package cn.jondai.guava.collection;

import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.sun.istack.internal.Nullable;

import cn.jondai.guava.geo.Continent;
import cn.jondai.guava.geo.Country;

/**
 * Collections2 提供了函数式的编程方法，transform(T,F) , filter(T,P);
 */
public class Collections2Test {

    @Test
    public void shouldTransformCollection() throws Exception {
        // given Collection2提供了函数式编程 transform(Collection,Function)返回一个Collection<T>对象
    	//Function只有apply和equal两个方法
        ArrayList<Country> countries = Lists.newArrayList(Country.POLAND, Country.BELGIUM, Country.ENGLAND);
        // when
        Collection<String> capitalCities = Collections2.transform(countries,
                new Function<Country, String>() {
                    public String apply(@Nullable Country country) {
                        return country.getCapitalCity();
                    }
                });
        // then
        assertThat(capitalCities,contains("Warsaw", "Brussels", "London"));
    }

    @Test
    public void shouldFilterCountriesOnlyFromAfrica() throws Exception {
        // given filter过滤器，Predicate提供的apply方法只返回一个boolean类型，为false的元素会被过滤掉
        ArrayList<Country> countries = Lists.newArrayList(Country.POLAND, Country.BELGIUM, Country.SOUTH_AFRICA);
        // when
        Collection<Country> countriesFromAfrica = Collections2.filter(countries, new Predicate<Country>() {
            public boolean apply(@Nullable Country country) {
                return Continent.AFRICA.equals(country.getContinent());
            }
        });
        // then
        assertThat(countriesFromAfrica,contains(Country.SOUTH_AFRICA));
    }

    @Test
    public void shouldShowThatResultIsOnlyAView() throws Exception {
        // given
        ArrayList<Country> countries = Lists.newArrayList(Country.POLAND, Country.BELGIUM, Country.ENGLAND);
        // when
        Collection<String> capitalCities = Collections2.transform(countries,
                new Function<Country, String>() {
                    public String apply(@Nullable Country country) {
                        return country.getCapitalCity();
                    }
                });
        // then
        assertThat(capitalCities,contains("Warsaw", "Brussels", "London"));
        assertFalse(capitalCities.contains("Pretoria"));
        countries.add(Country.SOUTH_AFRICA);
        assertTrue(capitalCities.contains("Pretoria"));
    }
}
