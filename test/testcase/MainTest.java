/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testcase;

import hjj.chnews.items.ItemsDAOTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import common.util.TestCase1;

/**
 *
 * @author rslee
 * @data 2010-7-9
 * 说明：这个MainTest有如下的功能：
 * 测试总集合
 */
@RunWith(Suite.class)
@SuiteClasses({TestCase1.class,ItemsDAOTest.class})
public class MainTest {
}
