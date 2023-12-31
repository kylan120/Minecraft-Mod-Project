package net.kylanjordanharry.projectminecraft;
import com.mojang.logging.LogUtils;
import net.kylanjordanharry.projectminecraft.item.ModItems;
import net.kylanjordanharry.projectminecraft.block.FaceBlocks;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

//Name: Kylan, Harry, and Jordan
// Description: This is the project class this is our main program that loads everything in minecraft
// Date: 9/28/2023
@Mod(project.MOD_ID)
public class project
{
    public static final String MOD_ID = "project";
    public static final Logger LOGGER = LogUtils.getLogger();

    public project()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus); // This will make sure our items are added to the game
        FaceBlocks.register(modEventBus); // This will make sure our blocks are added to the game
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        ;
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }


  // This adds the items to creative tabs
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)
        {
            event.accept(ModItems.KYLANFOOD);
            event.accept(ModItems.JORDANFOOD);
            event.accept((ModItems.HARRYFOOD));
        }

        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        {
            event.accept(ModItems.KYLAN);
            event.accept(ModItems.JORDAN);
            event.accept(ModItems.HARRY);

        }
        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS)
        {
            event.accept(FaceBlocks.KYLAN_BLOCK);
            event.accept(FaceBlocks.KYLAN_ORE);
            event.accept(FaceBlocks.KYLAN_ORE_DEEPSLATE);
            event.accept(FaceBlocks.KYLAN_ORE_NETHER);
            event.accept(FaceBlocks.JORDAN_BLOCK);
            event.accept(FaceBlocks.JORDAN_ORE);
            event.accept(FaceBlocks.JORDAN_ORE_DEEPSLATE);
            event.accept(FaceBlocks.JORDAN_ORE_NETHER);
            event.accept(FaceBlocks.HARRY_BLOCK);
            event.accept(FaceBlocks.HARRY_ORE);
            event.accept(FaceBlocks.HARRY_ORE_DEEPSLATE);
            event.accept(FaceBlocks.HARRY_ORE_NETHER);
        }
        if(event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS)
        {
            event.accept(FaceBlocks.KYLAN_UBER);
            event.accept(FaceBlocks.JORDAN_UBER);
            event.accept(FaceBlocks.HARRY_UBER);

        }
        if(event.getTabKey() == CreativeModeTabs.COMBAT)
        {
            event.accept(ModItems.JORDAN_HELMET);
            event.accept(ModItems.JORDAN_CHESTPLATE);
            event.accept(ModItems.JORDAN_LEGGINGS);
            event.accept(ModItems.JORDAN_BOOTS);
            event.accept(ModItems.KYLAN_HELMET);
            event.accept(ModItems.KYLAN_CHESTPLATE);
            event.accept(ModItems.KYLAN_LEGGINGS);
            event.accept(ModItems.KYLAN_BOOTS);
            event.accept(ModItems.HARRY_HELMET);
            event.accept(ModItems.HARRY_CHESTPLATE);
            event.accept(ModItems.HARRY_LEGGINGS);
            event.accept(ModItems.HARRY_BOOTS);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
