package telran.games;

public class BullsCowsMapImplTest extends BullsCowsTest{

	@Override
	protected BullsCowsService getBullsCowsImpl() {
		
		return new BullsCowsMapImpl();
	}

	@Override
	protected Game getGame(long id, BullsCowsService bullsCows) {
		
		return ((BullsCowsMapImpl)bullsCows).getGame(id);
	}

}
