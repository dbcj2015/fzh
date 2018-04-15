import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;


public class Recruit extends BreadthCrawler{

	public Recruit(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(Page arg0, CrawlDatums arg1) {
		
		
	}
	public static void main(String[] args) {
		Recruit crawler=new Recruit("recriut", true);
		crawler.setThreads(20);
		crawler.setResumable(true);
		
	}
}
