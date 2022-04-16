package bit.clots.ywk.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * mybatis 数据源
 *
 * @author admin
 */
public class DruidDataSourceFactory extends UnpooledDataSourceFactory {


    public DruidDataSourceFactory() {
        //创建数据源, 饿汉单例模式
        this.dataSource = new DruidDataSource();
    }

    @Override
    public DataSource getDataSource() {
        try {
            // 将上面创建好的数据源强制转换为 druid 的数据源, 并调用 druid 的初始化方法进行初始化
            ((DruidDataSource) this.dataSource).init();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.dataSource;
    }
}
