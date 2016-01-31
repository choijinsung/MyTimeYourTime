package cjs.example.com.mytimeyourtime;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements OnClickListener {

  private UserDBHandler uhandler;
  private Cursor ucursor;
  ListView mainTimeListView;

  private EditSelDialog editSelDialog;
  private DelSelDialog delSelDialog;
  private DelEntireTtabDialog delEntireTtabDialog;
  private DelEntireSchdlDialog delEntireSchdlDialog;
  private DelEntireDialog delEntireDialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_main);

    Button main_edit_btn = (Button)findViewById(R.id.main_edit_btn);
    main_edit_btn.setOnClickListener(this);

    Button main_del_btn = (Button)findViewById(R.id.main_del_btn);
    main_del_btn.setOnClickListener(this);

    Button main_add_frn_btn = (Button)findViewById(R.id.main_add_frn_btn);
    main_add_frn_btn.setOnClickListener(this);

    Button[] btnArray = new Button[901];

    btnArray[1] = (Button)findViewById(R.id.btn1);
    btnArray[2] = (Button)findViewById(R.id.btn2);
    btnArray[3] = (Button)findViewById(R.id.btn3);
    btnArray[4] = (Button)findViewById(R.id.btn4);
    btnArray[5] = (Button)findViewById(R.id.btn5);
    btnArray[6] = (Button)findViewById(R.id.btn6);
    btnArray[7] = (Button)findViewById(R.id.btn7);
    btnArray[8] = (Button)findViewById(R.id.btn8);
    btnArray[9] = (Button)findViewById(R.id.btn9);
    btnArray[10] = (Button)findViewById(R.id.btn10);
    btnArray[11] = (Button)findViewById(R.id.btn11);
    btnArray[12] = (Button)findViewById(R.id.btn12);
    btnArray[13] = (Button)findViewById(R.id.btn13);
    btnArray[14] = (Button)findViewById(R.id.btn14);
    btnArray[15] = (Button)findViewById(R.id.btn15);
    btnArray[16] = (Button)findViewById(R.id.btn16);
    btnArray[17] = (Button)findViewById(R.id.btn17);
    btnArray[18] = (Button)findViewById(R.id.btn18);
    btnArray[19] = (Button)findViewById(R.id.btn19);
    btnArray[20] = (Button)findViewById(R.id.btn20);
    btnArray[21] = (Button)findViewById(R.id.btn21);
    btnArray[22] = (Button)findViewById(R.id.btn22);
    btnArray[23] = (Button)findViewById(R.id.btn23);
    btnArray[24] = (Button)findViewById(R.id.btn24);
    btnArray[25] = (Button)findViewById(R.id.btn25);
    btnArray[26] = (Button)findViewById(R.id.btn26);
    btnArray[27] = (Button)findViewById(R.id.btn27);
    btnArray[28] = (Button)findViewById(R.id.btn28);
    btnArray[29] = (Button)findViewById(R.id.btn29);
    btnArray[30] = (Button)findViewById(R.id.btn30);
    btnArray[31] = (Button)findViewById(R.id.btn31);
    btnArray[32] = (Button)findViewById(R.id.btn32);
    btnArray[33] = (Button)findViewById(R.id.btn33);
    btnArray[34] = (Button)findViewById(R.id.btn34);
    btnArray[35] = (Button)findViewById(R.id.btn35);
    btnArray[36] = (Button)findViewById(R.id.btn36);
    btnArray[37] = (Button)findViewById(R.id.btn37);
    btnArray[38] = (Button)findViewById(R.id.btn38);
    btnArray[39] = (Button)findViewById(R.id.btn39);
    btnArray[40] = (Button)findViewById(R.id.btn40);
    btnArray[41] = (Button)findViewById(R.id.btn41);
    btnArray[42] = (Button)findViewById(R.id.btn42);
    btnArray[43] = (Button)findViewById(R.id.btn43);
    btnArray[44] = (Button)findViewById(R.id.btn44);
    btnArray[45] = (Button)findViewById(R.id.btn45);
    btnArray[46] = (Button)findViewById(R.id.btn46);
    btnArray[47] = (Button)findViewById(R.id.btn47);
    btnArray[48] = (Button)findViewById(R.id.btn48);
    btnArray[49] = (Button)findViewById(R.id.btn49);
    btnArray[50] = (Button)findViewById(R.id.btn50);
    btnArray[51] = (Button)findViewById(R.id.btn51);
    btnArray[52] = (Button)findViewById(R.id.btn52);
    btnArray[53] = (Button)findViewById(R.id.btn53);
    btnArray[54] = (Button)findViewById(R.id.btn54);
    btnArray[55] = (Button)findViewById(R.id.btn55);
    btnArray[56] = (Button)findViewById(R.id.btn56);
    btnArray[57] = (Button)findViewById(R.id.btn57);
    btnArray[58] = (Button)findViewById(R.id.btn58);
    btnArray[59] = (Button)findViewById(R.id.btn59);
    btnArray[60] = (Button)findViewById(R.id.btn60);
    btnArray[61] = (Button)findViewById(R.id.btn61);
    btnArray[62] = (Button)findViewById(R.id.btn62);
    btnArray[63] = (Button)findViewById(R.id.btn63);
    btnArray[64] = (Button)findViewById(R.id.btn64);
    btnArray[65] = (Button)findViewById(R.id.btn65);
    btnArray[66] = (Button)findViewById(R.id.btn66);
    btnArray[67] = (Button)findViewById(R.id.btn67);
    btnArray[68] = (Button)findViewById(R.id.btn68);
    btnArray[69] = (Button)findViewById(R.id.btn69);
    btnArray[70] = (Button)findViewById(R.id.btn70);
    btnArray[71] = (Button)findViewById(R.id.btn71);
    btnArray[72] = (Button)findViewById(R.id.btn72);
    btnArray[73] = (Button)findViewById(R.id.btn73);
    btnArray[74] = (Button)findViewById(R.id.btn74);
    btnArray[75] = (Button)findViewById(R.id.btn75);
    btnArray[76] = (Button)findViewById(R.id.btn76);
    btnArray[77] = (Button)findViewById(R.id.btn77);
    btnArray[78] = (Button)findViewById(R.id.btn78);
    btnArray[79] = (Button)findViewById(R.id.btn79);
    btnArray[80] = (Button)findViewById(R.id.btn80);
    btnArray[81] = (Button)findViewById(R.id.btn81);
    btnArray[82] = (Button)findViewById(R.id.btn82);
    btnArray[83] = (Button)findViewById(R.id.btn83);
    btnArray[84] = (Button)findViewById(R.id.btn84);
    btnArray[85] = (Button)findViewById(R.id.btn85);
    btnArray[86] = (Button)findViewById(R.id.btn86);
    btnArray[87] = (Button)findViewById(R.id.btn87);
    btnArray[88] = (Button)findViewById(R.id.btn88);
    btnArray[89] = (Button)findViewById(R.id.btn89);
    btnArray[90] = (Button)findViewById(R.id.btn90);
    btnArray[91] = (Button)findViewById(R.id.btn91);
    btnArray[92] = (Button)findViewById(R.id.btn92);
    btnArray[93] = (Button)findViewById(R.id.btn93);
    btnArray[94] = (Button)findViewById(R.id.btn94);
    btnArray[95] = (Button)findViewById(R.id.btn95);
    btnArray[96] = (Button)findViewById(R.id.btn96);
    btnArray[97] = (Button)findViewById(R.id.btn97);
    btnArray[98] = (Button)findViewById(R.id.btn98);
    btnArray[99] = (Button)findViewById(R.id.btn99);
    btnArray[100] = (Button)findViewById(R.id.btn100);

    btnArray[101] = (Button)findViewById(R.id.btn101);
    btnArray[102] = (Button)findViewById(R.id.btn102);
    btnArray[103] = (Button)findViewById(R.id.btn103);
    btnArray[104] = (Button)findViewById(R.id.btn104);
    btnArray[105] = (Button)findViewById(R.id.btn105);
    btnArray[106] = (Button)findViewById(R.id.btn106);
    btnArray[107] = (Button)findViewById(R.id.btn107);
    btnArray[108] = (Button)findViewById(R.id.btn108);
    btnArray[109] = (Button)findViewById(R.id.btn109);
    btnArray[110] = (Button)findViewById(R.id.btn110);
    btnArray[111] = (Button)findViewById(R.id.btn111);
    btnArray[112] = (Button)findViewById(R.id.btn112);
    btnArray[113] = (Button)findViewById(R.id.btn113);
    btnArray[114] = (Button)findViewById(R.id.btn114);
    btnArray[115] = (Button)findViewById(R.id.btn115);
    btnArray[116] = (Button)findViewById(R.id.btn116);
    btnArray[117] = (Button)findViewById(R.id.btn117);
    btnArray[118] = (Button)findViewById(R.id.btn118);
    btnArray[119] = (Button)findViewById(R.id.btn119);
    btnArray[120] = (Button)findViewById(R.id.btn120);
    btnArray[121] = (Button)findViewById(R.id.btn121);
    btnArray[122] = (Button)findViewById(R.id.btn122);
    btnArray[123] = (Button)findViewById(R.id.btn123);
    btnArray[124] = (Button)findViewById(R.id.btn124);
    btnArray[125] = (Button)findViewById(R.id.btn125);
    btnArray[126] = (Button)findViewById(R.id.btn126);
    btnArray[127] = (Button)findViewById(R.id.btn127);
    btnArray[128] = (Button)findViewById(R.id.btn128);
    btnArray[129] = (Button)findViewById(R.id.btn129);
    btnArray[130] = (Button)findViewById(R.id.btn130);
    btnArray[131] = (Button)findViewById(R.id.btn131);
    btnArray[132] = (Button)findViewById(R.id.btn132);
    btnArray[133] = (Button)findViewById(R.id.btn133);
    btnArray[134] = (Button)findViewById(R.id.btn134);
    btnArray[135] = (Button)findViewById(R.id.btn135);
    btnArray[136] = (Button)findViewById(R.id.btn136);
    btnArray[137] = (Button)findViewById(R.id.btn137);
    btnArray[138] = (Button)findViewById(R.id.btn138);
    btnArray[139] = (Button)findViewById(R.id.btn139);
    btnArray[140] = (Button)findViewById(R.id.btn140);
    btnArray[141] = (Button)findViewById(R.id.btn141);
    btnArray[142] = (Button)findViewById(R.id.btn142);
    btnArray[143] = (Button)findViewById(R.id.btn143);
    btnArray[144] = (Button)findViewById(R.id.btn144);
    btnArray[145] = (Button)findViewById(R.id.btn145);
    btnArray[146] = (Button)findViewById(R.id.btn146);
    btnArray[147] = (Button)findViewById(R.id.btn147);
    btnArray[148] = (Button)findViewById(R.id.btn148);
    btnArray[149] = (Button)findViewById(R.id.btn149);
    btnArray[150] = (Button)findViewById(R.id.btn150);
    btnArray[151] = (Button)findViewById(R.id.btn151);
    btnArray[152] = (Button)findViewById(R.id.btn152);
    btnArray[153] = (Button)findViewById(R.id.btn153);
    btnArray[154] = (Button)findViewById(R.id.btn154);
    btnArray[155] = (Button)findViewById(R.id.btn155);
    btnArray[156] = (Button)findViewById(R.id.btn156);
    btnArray[157] = (Button)findViewById(R.id.btn157);
    btnArray[158] = (Button)findViewById(R.id.btn158);
    btnArray[159] = (Button)findViewById(R.id.btn159);
    btnArray[160] = (Button)findViewById(R.id.btn160);
    btnArray[161] = (Button)findViewById(R.id.btn161);
    btnArray[162] = (Button)findViewById(R.id.btn162);
    btnArray[163] = (Button)findViewById(R.id.btn163);
    btnArray[164] = (Button)findViewById(R.id.btn164);
    btnArray[165] = (Button)findViewById(R.id.btn165);
    btnArray[166] = (Button)findViewById(R.id.btn166);
    btnArray[167] = (Button)findViewById(R.id.btn167);
    btnArray[168] = (Button)findViewById(R.id.btn168);
    btnArray[169] = (Button)findViewById(R.id.btn169);
    btnArray[170] = (Button)findViewById(R.id.btn170);
    btnArray[171] = (Button)findViewById(R.id.btn171);
    btnArray[172] = (Button)findViewById(R.id.btn172);
    btnArray[173] = (Button)findViewById(R.id.btn173);
    btnArray[174] = (Button)findViewById(R.id.btn174);
    btnArray[175] = (Button)findViewById(R.id.btn175);
    btnArray[176] = (Button)findViewById(R.id.btn176);
    btnArray[177] = (Button)findViewById(R.id.btn177);
    btnArray[178] = (Button)findViewById(R.id.btn178);
    btnArray[179] = (Button)findViewById(R.id.btn179);
    btnArray[180] = (Button)findViewById(R.id.btn180);
    btnArray[181] = (Button)findViewById(R.id.btn181);
    btnArray[182] = (Button)findViewById(R.id.btn182);
    btnArray[183] = (Button)findViewById(R.id.btn183);
    btnArray[184] = (Button)findViewById(R.id.btn184);
    btnArray[185] = (Button)findViewById(R.id.btn185);
    btnArray[186] = (Button)findViewById(R.id.btn186);
    btnArray[187] = (Button)findViewById(R.id.btn187);
    btnArray[188] = (Button)findViewById(R.id.btn188);
    btnArray[189] = (Button)findViewById(R.id.btn189);
    btnArray[190] = (Button)findViewById(R.id.btn190);
    btnArray[191] = (Button)findViewById(R.id.btn191);
    btnArray[192] = (Button)findViewById(R.id.btn192);
    btnArray[193] = (Button)findViewById(R.id.btn193);
    btnArray[194] = (Button)findViewById(R.id.btn194);
    btnArray[195] = (Button)findViewById(R.id.btn195);
    btnArray[196] = (Button)findViewById(R.id.btn196);
    btnArray[197] = (Button)findViewById(R.id.btn197);
    btnArray[198] = (Button)findViewById(R.id.btn198);
    btnArray[199] = (Button)findViewById(R.id.btn199);
    btnArray[200] = (Button)findViewById(R.id.btn200);

    btnArray[201] = (Button)findViewById(R.id.btn201);
    btnArray[202] = (Button)findViewById(R.id.btn202);
    btnArray[203] = (Button)findViewById(R.id.btn203);
    btnArray[204] = (Button)findViewById(R.id.btn204);
    btnArray[205] = (Button)findViewById(R.id.btn205);
    btnArray[206] = (Button)findViewById(R.id.btn206);
    btnArray[207] = (Button)findViewById(R.id.btn207);
    btnArray[208] = (Button)findViewById(R.id.btn208);
    btnArray[209] = (Button)findViewById(R.id.btn209);
    btnArray[210] = (Button)findViewById(R.id.btn210);
    btnArray[211] = (Button)findViewById(R.id.btn211);
    btnArray[212] = (Button)findViewById(R.id.btn212);
    btnArray[213] = (Button)findViewById(R.id.btn213);
    btnArray[214] = (Button)findViewById(R.id.btn214);
    btnArray[215] = (Button)findViewById(R.id.btn215);
    btnArray[216] = (Button)findViewById(R.id.btn216);
    btnArray[217] = (Button)findViewById(R.id.btn217);
    btnArray[218] = (Button)findViewById(R.id.btn218);
    btnArray[219] = (Button)findViewById(R.id.btn219);
    btnArray[220] = (Button)findViewById(R.id.btn220);
    btnArray[221] = (Button)findViewById(R.id.btn221);
    btnArray[222] = (Button)findViewById(R.id.btn222);
    btnArray[223] = (Button)findViewById(R.id.btn223);
    btnArray[224] = (Button)findViewById(R.id.btn224);
    btnArray[225] = (Button)findViewById(R.id.btn225);
    btnArray[226] = (Button)findViewById(R.id.btn226);
    btnArray[227] = (Button)findViewById(R.id.btn227);
    btnArray[228] = (Button)findViewById(R.id.btn228);
    btnArray[229] = (Button)findViewById(R.id.btn229);
    btnArray[230] = (Button)findViewById(R.id.btn230);
    btnArray[231] = (Button)findViewById(R.id.btn231);
    btnArray[232] = (Button)findViewById(R.id.btn232);
    btnArray[233] = (Button)findViewById(R.id.btn233);
    btnArray[234] = (Button)findViewById(R.id.btn234);
    btnArray[235] = (Button)findViewById(R.id.btn235);
    btnArray[236] = (Button)findViewById(R.id.btn236);
    btnArray[237] = (Button)findViewById(R.id.btn237);
    btnArray[238] = (Button)findViewById(R.id.btn238);
    btnArray[239] = (Button)findViewById(R.id.btn239);
    btnArray[240] = (Button)findViewById(R.id.btn240);
    btnArray[241] = (Button)findViewById(R.id.btn241);
    btnArray[242] = (Button)findViewById(R.id.btn242);
    btnArray[243] = (Button)findViewById(R.id.btn243);
    btnArray[244] = (Button)findViewById(R.id.btn244);
    btnArray[245] = (Button)findViewById(R.id.btn245);
    btnArray[246] = (Button)findViewById(R.id.btn246);
    btnArray[247] = (Button)findViewById(R.id.btn247);
    btnArray[248] = (Button)findViewById(R.id.btn248);
    btnArray[249] = (Button)findViewById(R.id.btn249);
    btnArray[250] = (Button)findViewById(R.id.btn250);
    btnArray[251] = (Button)findViewById(R.id.btn251);
    btnArray[252] = (Button)findViewById(R.id.btn252);
    btnArray[253] = (Button)findViewById(R.id.btn253);
    btnArray[254] = (Button)findViewById(R.id.btn254);
    btnArray[255] = (Button)findViewById(R.id.btn255);
    btnArray[256] = (Button)findViewById(R.id.btn256);
    btnArray[257] = (Button)findViewById(R.id.btn257);
    btnArray[258] = (Button)findViewById(R.id.btn258);
    btnArray[259] = (Button)findViewById(R.id.btn259);
    btnArray[260] = (Button)findViewById(R.id.btn260);
    btnArray[261] = (Button)findViewById(R.id.btn261);
    btnArray[262] = (Button)findViewById(R.id.btn262);
    btnArray[263] = (Button)findViewById(R.id.btn263);
    btnArray[264] = (Button)findViewById(R.id.btn264);
    btnArray[265] = (Button)findViewById(R.id.btn265);
    btnArray[266] = (Button)findViewById(R.id.btn266);
    btnArray[267] = (Button)findViewById(R.id.btn267);
    btnArray[268] = (Button)findViewById(R.id.btn268);
    btnArray[269] = (Button)findViewById(R.id.btn269);
    btnArray[270] = (Button)findViewById(R.id.btn270);
    btnArray[271] = (Button)findViewById(R.id.btn271);
    btnArray[272] = (Button)findViewById(R.id.btn272);
    btnArray[273] = (Button)findViewById(R.id.btn273);
    btnArray[274] = (Button)findViewById(R.id.btn274);
    btnArray[275] = (Button)findViewById(R.id.btn275);
    btnArray[276] = (Button)findViewById(R.id.btn276);
    btnArray[277] = (Button)findViewById(R.id.btn277);
    btnArray[278] = (Button)findViewById(R.id.btn278);
    btnArray[279] = (Button)findViewById(R.id.btn279);
    btnArray[280] = (Button)findViewById(R.id.btn280);
    btnArray[281] = (Button)findViewById(R.id.btn281);
    btnArray[282] = (Button)findViewById(R.id.btn282);
    btnArray[283] = (Button)findViewById(R.id.btn283);
    btnArray[284] = (Button)findViewById(R.id.btn284);
    btnArray[285] = (Button)findViewById(R.id.btn285);
    btnArray[286] = (Button)findViewById(R.id.btn286);
    btnArray[287] = (Button)findViewById(R.id.btn287);
    btnArray[288] = (Button)findViewById(R.id.btn288);
    btnArray[289] = (Button)findViewById(R.id.btn289);
    btnArray[290] = (Button)findViewById(R.id.btn290);
    btnArray[291] = (Button)findViewById(R.id.btn291);
    btnArray[292] = (Button)findViewById(R.id.btn292);
    btnArray[293] = (Button)findViewById(R.id.btn293);
    btnArray[294] = (Button)findViewById(R.id.btn294);
    btnArray[295] = (Button)findViewById(R.id.btn295);
    btnArray[296] = (Button)findViewById(R.id.btn296);
    btnArray[297] = (Button)findViewById(R.id.btn297);
    btnArray[298] = (Button)findViewById(R.id.btn298);
    btnArray[299] = (Button)findViewById(R.id.btn299);
    btnArray[300] = (Button)findViewById(R.id.btn300);

    btnArray[301] = (Button)findViewById(R.id.btn301);
    btnArray[302] = (Button)findViewById(R.id.btn302);
    btnArray[303] = (Button)findViewById(R.id.btn303);
    btnArray[304] = (Button)findViewById(R.id.btn304);
    btnArray[305] = (Button)findViewById(R.id.btn305);
    btnArray[306] = (Button)findViewById(R.id.btn306);
    btnArray[307] = (Button)findViewById(R.id.btn307);
    btnArray[308] = (Button)findViewById(R.id.btn308);
    btnArray[309] = (Button)findViewById(R.id.btn309);
    btnArray[310] = (Button)findViewById(R.id.btn310);
    btnArray[311] = (Button)findViewById(R.id.btn311);
    btnArray[312] = (Button)findViewById(R.id.btn312);
    btnArray[313] = (Button)findViewById(R.id.btn313);
    btnArray[314] = (Button)findViewById(R.id.btn314);
    btnArray[315] = (Button)findViewById(R.id.btn315);
    btnArray[316] = (Button)findViewById(R.id.btn316);
    btnArray[317] = (Button)findViewById(R.id.btn317);
    btnArray[318] = (Button)findViewById(R.id.btn318);
    btnArray[319] = (Button)findViewById(R.id.btn319);
    btnArray[320] = (Button)findViewById(R.id.btn320);
    btnArray[321] = (Button)findViewById(R.id.btn321);
    btnArray[322] = (Button)findViewById(R.id.btn322);
    btnArray[323] = (Button)findViewById(R.id.btn323);
    btnArray[324] = (Button)findViewById(R.id.btn324);
    btnArray[325] = (Button)findViewById(R.id.btn325);
    btnArray[326] = (Button)findViewById(R.id.btn326);
    btnArray[327] = (Button)findViewById(R.id.btn327);
    btnArray[328] = (Button)findViewById(R.id.btn328);
    btnArray[329] = (Button)findViewById(R.id.btn329);
    btnArray[330] = (Button)findViewById(R.id.btn330);
    btnArray[331] = (Button)findViewById(R.id.btn331);
    btnArray[332] = (Button)findViewById(R.id.btn332);
    btnArray[333] = (Button)findViewById(R.id.btn333);
    btnArray[334] = (Button)findViewById(R.id.btn334);
    btnArray[335] = (Button)findViewById(R.id.btn335);
    btnArray[336] = (Button)findViewById(R.id.btn336);
    btnArray[337] = (Button)findViewById(R.id.btn337);
    btnArray[338] = (Button)findViewById(R.id.btn338);
    btnArray[339] = (Button)findViewById(R.id.btn339);
    btnArray[340] = (Button)findViewById(R.id.btn340);
    btnArray[341] = (Button)findViewById(R.id.btn341);
    btnArray[342] = (Button)findViewById(R.id.btn342);
    btnArray[343] = (Button)findViewById(R.id.btn343);
    btnArray[344] = (Button)findViewById(R.id.btn344);
    btnArray[345] = (Button)findViewById(R.id.btn345);
    btnArray[346] = (Button)findViewById(R.id.btn346);
    btnArray[347] = (Button)findViewById(R.id.btn347);
    btnArray[348] = (Button)findViewById(R.id.btn348);
    btnArray[349] = (Button)findViewById(R.id.btn349);
    btnArray[350] = (Button)findViewById(R.id.btn350);
    btnArray[351] = (Button)findViewById(R.id.btn351);
    btnArray[352] = (Button)findViewById(R.id.btn352);
    btnArray[353] = (Button)findViewById(R.id.btn353);
    btnArray[354] = (Button)findViewById(R.id.btn354);
    btnArray[355] = (Button)findViewById(R.id.btn355);
    btnArray[356] = (Button)findViewById(R.id.btn356);
    btnArray[357] = (Button)findViewById(R.id.btn357);
    btnArray[358] = (Button)findViewById(R.id.btn358);
    btnArray[359] = (Button)findViewById(R.id.btn359);
    btnArray[360] = (Button)findViewById(R.id.btn360);
    btnArray[361] = (Button)findViewById(R.id.btn361);
    btnArray[362] = (Button)findViewById(R.id.btn362);
    btnArray[363] = (Button)findViewById(R.id.btn363);
    btnArray[364] = (Button)findViewById(R.id.btn364);
    btnArray[365] = (Button)findViewById(R.id.btn365);
    btnArray[366] = (Button)findViewById(R.id.btn366);
    btnArray[367] = (Button)findViewById(R.id.btn367);
    btnArray[368] = (Button)findViewById(R.id.btn368);
    btnArray[369] = (Button)findViewById(R.id.btn369);
    btnArray[370] = (Button)findViewById(R.id.btn370);
    btnArray[371] = (Button)findViewById(R.id.btn371);
    btnArray[372] = (Button)findViewById(R.id.btn372);
    btnArray[373] = (Button)findViewById(R.id.btn373);
    btnArray[374] = (Button)findViewById(R.id.btn374);
    btnArray[375] = (Button)findViewById(R.id.btn375);
    btnArray[376] = (Button)findViewById(R.id.btn376);
    btnArray[377] = (Button)findViewById(R.id.btn377);
    btnArray[378] = (Button)findViewById(R.id.btn378);
    btnArray[379] = (Button)findViewById(R.id.btn379);
    btnArray[380] = (Button)findViewById(R.id.btn380);
    btnArray[381] = (Button)findViewById(R.id.btn381);
    btnArray[382] = (Button)findViewById(R.id.btn382);
    btnArray[383] = (Button)findViewById(R.id.btn383);
    btnArray[384] = (Button)findViewById(R.id.btn384);
    btnArray[385] = (Button)findViewById(R.id.btn385);
    btnArray[386] = (Button)findViewById(R.id.btn386);
    btnArray[387] = (Button)findViewById(R.id.btn387);
    btnArray[388] = (Button)findViewById(R.id.btn388);
    btnArray[389] = (Button)findViewById(R.id.btn389);
    btnArray[390] = (Button)findViewById(R.id.btn390);
    btnArray[391] = (Button)findViewById(R.id.btn391);
    btnArray[392] = (Button)findViewById(R.id.btn392);
    btnArray[393] = (Button)findViewById(R.id.btn393);
    btnArray[394] = (Button)findViewById(R.id.btn394);
    btnArray[395] = (Button)findViewById(R.id.btn395);
    btnArray[396] = (Button)findViewById(R.id.btn396);
    btnArray[397] = (Button)findViewById(R.id.btn397);
    btnArray[398] = (Button)findViewById(R.id.btn398);
    btnArray[399] = (Button)findViewById(R.id.btn399);
    btnArray[400] = (Button)findViewById(R.id.btn400);

    btnArray[401] = (Button)findViewById(R.id.btn401);
    btnArray[402] = (Button)findViewById(R.id.btn402);
    btnArray[403] = (Button)findViewById(R.id.btn403);
    btnArray[404] = (Button)findViewById(R.id.btn404);
    btnArray[405] = (Button)findViewById(R.id.btn405);
    btnArray[406] = (Button)findViewById(R.id.btn406);
    btnArray[407] = (Button)findViewById(R.id.btn407);
    btnArray[408] = (Button)findViewById(R.id.btn408);
    btnArray[409] = (Button)findViewById(R.id.btn409);
    btnArray[410] = (Button)findViewById(R.id.btn410);
    btnArray[411] = (Button)findViewById(R.id.btn411);
    btnArray[412] = (Button)findViewById(R.id.btn412);
    btnArray[413] = (Button)findViewById(R.id.btn413);
    btnArray[414] = (Button)findViewById(R.id.btn414);
    btnArray[415] = (Button)findViewById(R.id.btn415);
    btnArray[416] = (Button)findViewById(R.id.btn416);
    btnArray[417] = (Button)findViewById(R.id.btn417);
    btnArray[418] = (Button)findViewById(R.id.btn418);
    btnArray[419] = (Button)findViewById(R.id.btn419);
    btnArray[420] = (Button)findViewById(R.id.btn420);
    btnArray[421] = (Button)findViewById(R.id.btn421);
    btnArray[422] = (Button)findViewById(R.id.btn422);
    btnArray[423] = (Button)findViewById(R.id.btn423);
    btnArray[424] = (Button)findViewById(R.id.btn424);
    btnArray[425] = (Button)findViewById(R.id.btn425);
    btnArray[426] = (Button)findViewById(R.id.btn426);
    btnArray[427] = (Button)findViewById(R.id.btn427);
    btnArray[428] = (Button)findViewById(R.id.btn428);
    btnArray[429] = (Button)findViewById(R.id.btn429);
    btnArray[430] = (Button)findViewById(R.id.btn430);
    btnArray[431] = (Button)findViewById(R.id.btn431);
    btnArray[432] = (Button)findViewById(R.id.btn432);
    btnArray[433] = (Button)findViewById(R.id.btn433);
    btnArray[434] = (Button)findViewById(R.id.btn434);
    btnArray[435] = (Button)findViewById(R.id.btn435);
    btnArray[436] = (Button)findViewById(R.id.btn436);
    btnArray[437] = (Button)findViewById(R.id.btn437);
    btnArray[438] = (Button)findViewById(R.id.btn438);
    btnArray[439] = (Button)findViewById(R.id.btn439);
    btnArray[440] = (Button)findViewById(R.id.btn440);
    btnArray[441] = (Button)findViewById(R.id.btn441);
    btnArray[442] = (Button)findViewById(R.id.btn442);
    btnArray[443] = (Button)findViewById(R.id.btn443);
    btnArray[444] = (Button)findViewById(R.id.btn444);
    btnArray[445] = (Button)findViewById(R.id.btn445);
    btnArray[446] = (Button)findViewById(R.id.btn446);
    btnArray[447] = (Button)findViewById(R.id.btn447);
    btnArray[448] = (Button)findViewById(R.id.btn448);
    btnArray[449] = (Button)findViewById(R.id.btn449);
    btnArray[450] = (Button)findViewById(R.id.btn450);
    btnArray[451] = (Button)findViewById(R.id.btn451);
    btnArray[452] = (Button)findViewById(R.id.btn452);
    btnArray[453] = (Button)findViewById(R.id.btn453);
    btnArray[454] = (Button)findViewById(R.id.btn454);
    btnArray[455] = (Button)findViewById(R.id.btn455);
    btnArray[456] = (Button)findViewById(R.id.btn456);
    btnArray[457] = (Button)findViewById(R.id.btn457);
    btnArray[458] = (Button)findViewById(R.id.btn458);
    btnArray[459] = (Button)findViewById(R.id.btn459);
    btnArray[460] = (Button)findViewById(R.id.btn460);
    btnArray[461] = (Button)findViewById(R.id.btn461);
    btnArray[462] = (Button)findViewById(R.id.btn462);
    btnArray[463] = (Button)findViewById(R.id.btn463);
    btnArray[464] = (Button)findViewById(R.id.btn464);
    btnArray[465] = (Button)findViewById(R.id.btn465);
    btnArray[466] = (Button)findViewById(R.id.btn466);
    btnArray[467] = (Button)findViewById(R.id.btn467);
    btnArray[468] = (Button)findViewById(R.id.btn468);
    btnArray[469] = (Button)findViewById(R.id.btn469);
    btnArray[470] = (Button)findViewById(R.id.btn470);
    btnArray[471] = (Button)findViewById(R.id.btn471);
    btnArray[472] = (Button)findViewById(R.id.btn472);
    btnArray[473] = (Button)findViewById(R.id.btn473);
    btnArray[474] = (Button)findViewById(R.id.btn474);
    btnArray[475] = (Button)findViewById(R.id.btn475);
    btnArray[476] = (Button)findViewById(R.id.btn476);
    btnArray[477] = (Button)findViewById(R.id.btn477);
    btnArray[478] = (Button)findViewById(R.id.btn478);
    btnArray[479] = (Button)findViewById(R.id.btn479);
    btnArray[480] = (Button)findViewById(R.id.btn480);
    btnArray[481] = (Button)findViewById(R.id.btn481);
    btnArray[482] = (Button)findViewById(R.id.btn482);
    btnArray[483] = (Button)findViewById(R.id.btn483);
    btnArray[484] = (Button)findViewById(R.id.btn484);
    btnArray[485] = (Button)findViewById(R.id.btn485);
    btnArray[486] = (Button)findViewById(R.id.btn486);
    btnArray[487] = (Button)findViewById(R.id.btn487);
    btnArray[488] = (Button)findViewById(R.id.btn488);
    btnArray[489] = (Button)findViewById(R.id.btn489);
    btnArray[490] = (Button)findViewById(R.id.btn490);
    btnArray[491] = (Button)findViewById(R.id.btn491);
    btnArray[492] = (Button)findViewById(R.id.btn492);
    btnArray[493] = (Button)findViewById(R.id.btn493);
    btnArray[494] = (Button)findViewById(R.id.btn494);
    btnArray[495] = (Button)findViewById(R.id.btn495);
    btnArray[496] = (Button)findViewById(R.id.btn496);
    btnArray[497] = (Button)findViewById(R.id.btn497);
    btnArray[498] = (Button)findViewById(R.id.btn498);
    btnArray[499] = (Button)findViewById(R.id.btn499);
    btnArray[500] = (Button)findViewById(R.id.btn500);

    btnArray[501] = (Button)findViewById(R.id.btn501);
    btnArray[502] = (Button)findViewById(R.id.btn502);
    btnArray[503] = (Button)findViewById(R.id.btn503);
    btnArray[504] = (Button)findViewById(R.id.btn504);
    btnArray[505] = (Button)findViewById(R.id.btn505);
    btnArray[506] = (Button)findViewById(R.id.btn506);
    btnArray[507] = (Button)findViewById(R.id.btn507);
    btnArray[508] = (Button)findViewById(R.id.btn508);
    btnArray[509] = (Button)findViewById(R.id.btn509);
    btnArray[510] = (Button)findViewById(R.id.btn510);
    btnArray[511] = (Button)findViewById(R.id.btn511);
    btnArray[512] = (Button)findViewById(R.id.btn512);
    btnArray[513] = (Button)findViewById(R.id.btn513);
    btnArray[514] = (Button)findViewById(R.id.btn514);
    btnArray[515] = (Button)findViewById(R.id.btn515);
    btnArray[516] = (Button)findViewById(R.id.btn516);
    btnArray[517] = (Button)findViewById(R.id.btn517);
    btnArray[518] = (Button)findViewById(R.id.btn518);
    btnArray[519] = (Button)findViewById(R.id.btn519);
    btnArray[520] = (Button)findViewById(R.id.btn520);
    btnArray[521] = (Button)findViewById(R.id.btn521);
    btnArray[522] = (Button)findViewById(R.id.btn522);
    btnArray[523] = (Button)findViewById(R.id.btn523);
    btnArray[524] = (Button)findViewById(R.id.btn524);
    btnArray[525] = (Button)findViewById(R.id.btn525);
    btnArray[526] = (Button)findViewById(R.id.btn526);
    btnArray[527] = (Button)findViewById(R.id.btn527);
    btnArray[528] = (Button)findViewById(R.id.btn528);
    btnArray[529] = (Button)findViewById(R.id.btn529);
    btnArray[530] = (Button)findViewById(R.id.btn530);
    btnArray[531] = (Button)findViewById(R.id.btn531);
    btnArray[532] = (Button)findViewById(R.id.btn532);
    btnArray[533] = (Button)findViewById(R.id.btn533);
    btnArray[534] = (Button)findViewById(R.id.btn534);
    btnArray[535] = (Button)findViewById(R.id.btn535);
    btnArray[536] = (Button)findViewById(R.id.btn536);
    btnArray[537] = (Button)findViewById(R.id.btn537);
    btnArray[538] = (Button)findViewById(R.id.btn538);
    btnArray[539] = (Button)findViewById(R.id.btn539);
    btnArray[540] = (Button)findViewById(R.id.btn540);
    btnArray[541] = (Button)findViewById(R.id.btn541);
    btnArray[542] = (Button)findViewById(R.id.btn542);
    btnArray[543] = (Button)findViewById(R.id.btn543);
    btnArray[544] = (Button)findViewById(R.id.btn544);
    btnArray[545] = (Button)findViewById(R.id.btn545);
    btnArray[546] = (Button)findViewById(R.id.btn546);
    btnArray[547] = (Button)findViewById(R.id.btn547);
    btnArray[548] = (Button)findViewById(R.id.btn548);
    btnArray[549] = (Button)findViewById(R.id.btn549);
    btnArray[550] = (Button)findViewById(R.id.btn550);
    btnArray[551] = (Button)findViewById(R.id.btn551);
    btnArray[552] = (Button)findViewById(R.id.btn552);
    btnArray[553] = (Button)findViewById(R.id.btn553);
    btnArray[554] = (Button)findViewById(R.id.btn554);
    btnArray[555] = (Button)findViewById(R.id.btn555);
    btnArray[556] = (Button)findViewById(R.id.btn556);
    btnArray[557] = (Button)findViewById(R.id.btn557);
    btnArray[558] = (Button)findViewById(R.id.btn558);
    btnArray[559] = (Button)findViewById(R.id.btn559);
    btnArray[560] = (Button)findViewById(R.id.btn560);
    btnArray[561] = (Button)findViewById(R.id.btn561);
    btnArray[562] = (Button)findViewById(R.id.btn562);
    btnArray[563] = (Button)findViewById(R.id.btn563);
    btnArray[564] = (Button)findViewById(R.id.btn564);
    btnArray[565] = (Button)findViewById(R.id.btn565);
    btnArray[566] = (Button)findViewById(R.id.btn566);
    btnArray[567] = (Button)findViewById(R.id.btn567);
    btnArray[568] = (Button)findViewById(R.id.btn568);
    btnArray[569] = (Button)findViewById(R.id.btn569);
    btnArray[570] = (Button)findViewById(R.id.btn570);
    btnArray[571] = (Button)findViewById(R.id.btn571);
    btnArray[572] = (Button)findViewById(R.id.btn572);
    btnArray[573] = (Button)findViewById(R.id.btn573);
    btnArray[574] = (Button)findViewById(R.id.btn574);
    btnArray[575] = (Button)findViewById(R.id.btn575);
    btnArray[576] = (Button)findViewById(R.id.btn576);
    btnArray[577] = (Button)findViewById(R.id.btn577);
    btnArray[578] = (Button)findViewById(R.id.btn578);
    btnArray[579] = (Button)findViewById(R.id.btn579);
    btnArray[580] = (Button)findViewById(R.id.btn580);
    btnArray[581] = (Button)findViewById(R.id.btn581);
    btnArray[582] = (Button)findViewById(R.id.btn582);
    btnArray[583] = (Button)findViewById(R.id.btn583);
    btnArray[584] = (Button)findViewById(R.id.btn584);
    btnArray[585] = (Button)findViewById(R.id.btn585);
    btnArray[586] = (Button)findViewById(R.id.btn586);
    btnArray[587] = (Button)findViewById(R.id.btn587);
    btnArray[588] = (Button)findViewById(R.id.btn588);
    btnArray[589] = (Button)findViewById(R.id.btn589);
    btnArray[590] = (Button)findViewById(R.id.btn590);
    btnArray[591] = (Button)findViewById(R.id.btn591);
    btnArray[592] = (Button)findViewById(R.id.btn592);
    btnArray[593] = (Button)findViewById(R.id.btn593);
    btnArray[594] = (Button)findViewById(R.id.btn594);
    btnArray[595] = (Button)findViewById(R.id.btn595);
    btnArray[596] = (Button)findViewById(R.id.btn596);
    btnArray[597] = (Button)findViewById(R.id.btn597);
    btnArray[598] = (Button)findViewById(R.id.btn598);
    btnArray[599] = (Button)findViewById(R.id.btn599);
    btnArray[600] = (Button)findViewById(R.id.btn600);

    btnArray[601] = (Button)findViewById(R.id.btn601);
    btnArray[602] = (Button)findViewById(R.id.btn602);
    btnArray[603] = (Button)findViewById(R.id.btn603);
    btnArray[604] = (Button)findViewById(R.id.btn604);
    btnArray[605] = (Button)findViewById(R.id.btn605);
    btnArray[606] = (Button)findViewById(R.id.btn606);
    btnArray[607] = (Button)findViewById(R.id.btn607);
    btnArray[608] = (Button)findViewById(R.id.btn608);
    btnArray[609] = (Button)findViewById(R.id.btn609);
    btnArray[610] = (Button)findViewById(R.id.btn610);
    btnArray[611] = (Button)findViewById(R.id.btn611);
    btnArray[612] = (Button)findViewById(R.id.btn612);
    btnArray[613] = (Button)findViewById(R.id.btn613);
    btnArray[614] = (Button)findViewById(R.id.btn614);
    btnArray[615] = (Button)findViewById(R.id.btn615);
    btnArray[616] = (Button)findViewById(R.id.btn616);
    btnArray[617] = (Button)findViewById(R.id.btn617);
    btnArray[618] = (Button)findViewById(R.id.btn618);
    btnArray[619] = (Button)findViewById(R.id.btn619);
    btnArray[620] = (Button)findViewById(R.id.btn620);
    btnArray[621] = (Button)findViewById(R.id.btn621);
    btnArray[622] = (Button)findViewById(R.id.btn622);
    btnArray[623] = (Button)findViewById(R.id.btn623);
    btnArray[624] = (Button)findViewById(R.id.btn624);
    btnArray[625] = (Button)findViewById(R.id.btn625);
    btnArray[626] = (Button)findViewById(R.id.btn626);
    btnArray[627] = (Button)findViewById(R.id.btn627);
    btnArray[628] = (Button)findViewById(R.id.btn628);
    btnArray[629] = (Button)findViewById(R.id.btn629);
    btnArray[630] = (Button)findViewById(R.id.btn630);
    btnArray[631] = (Button)findViewById(R.id.btn631);
    btnArray[632] = (Button)findViewById(R.id.btn632);
    btnArray[633] = (Button)findViewById(R.id.btn633);
    btnArray[634] = (Button)findViewById(R.id.btn634);
    btnArray[635] = (Button)findViewById(R.id.btn635);
    btnArray[636] = (Button)findViewById(R.id.btn636);
    btnArray[637] = (Button)findViewById(R.id.btn637);
    btnArray[638] = (Button)findViewById(R.id.btn638);
    btnArray[639] = (Button)findViewById(R.id.btn639);
    btnArray[640] = (Button)findViewById(R.id.btn640);
    btnArray[641] = (Button)findViewById(R.id.btn641);
    btnArray[642] = (Button)findViewById(R.id.btn642);
    btnArray[643] = (Button)findViewById(R.id.btn643);
    btnArray[644] = (Button)findViewById(R.id.btn644);
    btnArray[645] = (Button)findViewById(R.id.btn645);
    btnArray[646] = (Button)findViewById(R.id.btn646);
    btnArray[647] = (Button)findViewById(R.id.btn647);
    btnArray[648] = (Button)findViewById(R.id.btn648);
    btnArray[649] = (Button)findViewById(R.id.btn649);
    btnArray[650] = (Button)findViewById(R.id.btn650);
    btnArray[651] = (Button)findViewById(R.id.btn651);
    btnArray[652] = (Button)findViewById(R.id.btn652);
    btnArray[653] = (Button)findViewById(R.id.btn653);
    btnArray[654] = (Button)findViewById(R.id.btn654);
    btnArray[655] = (Button)findViewById(R.id.btn655);
    btnArray[656] = (Button)findViewById(R.id.btn656);
    btnArray[657] = (Button)findViewById(R.id.btn657);
    btnArray[658] = (Button)findViewById(R.id.btn658);
    btnArray[659] = (Button)findViewById(R.id.btn659);
    btnArray[660] = (Button)findViewById(R.id.btn660);
    btnArray[661] = (Button)findViewById(R.id.btn661);
    btnArray[662] = (Button)findViewById(R.id.btn662);
    btnArray[663] = (Button)findViewById(R.id.btn663);
    btnArray[664] = (Button)findViewById(R.id.btn664);
    btnArray[665] = (Button)findViewById(R.id.btn665);
    btnArray[666] = (Button)findViewById(R.id.btn666);
    btnArray[667] = (Button)findViewById(R.id.btn667);
    btnArray[668] = (Button)findViewById(R.id.btn668);
    btnArray[669] = (Button)findViewById(R.id.btn669);
    btnArray[670] = (Button)findViewById(R.id.btn670);
    btnArray[671] = (Button)findViewById(R.id.btn671);
    btnArray[672] = (Button)findViewById(R.id.btn672);
    btnArray[673] = (Button)findViewById(R.id.btn673);
    btnArray[674] = (Button)findViewById(R.id.btn674);
    btnArray[675] = (Button)findViewById(R.id.btn675);
    btnArray[676] = (Button)findViewById(R.id.btn676);
    btnArray[677] = (Button)findViewById(R.id.btn677);
    btnArray[678] = (Button)findViewById(R.id.btn678);
    btnArray[679] = (Button)findViewById(R.id.btn679);
    btnArray[680] = (Button)findViewById(R.id.btn680);
    btnArray[681] = (Button)findViewById(R.id.btn681);
    btnArray[682] = (Button)findViewById(R.id.btn682);
    btnArray[683] = (Button)findViewById(R.id.btn683);
    btnArray[684] = (Button)findViewById(R.id.btn684);
    btnArray[685] = (Button)findViewById(R.id.btn685);
    btnArray[686] = (Button)findViewById(R.id.btn686);
    btnArray[687] = (Button)findViewById(R.id.btn687);
    btnArray[688] = (Button)findViewById(R.id.btn688);
    btnArray[689] = (Button)findViewById(R.id.btn689);
    btnArray[690] = (Button)findViewById(R.id.btn690);
    btnArray[691] = (Button)findViewById(R.id.btn691);
    btnArray[692] = (Button)findViewById(R.id.btn692);
    btnArray[693] = (Button)findViewById(R.id.btn693);
    btnArray[694] = (Button)findViewById(R.id.btn694);
    btnArray[695] = (Button)findViewById(R.id.btn695);
    btnArray[696] = (Button)findViewById(R.id.btn696);
    btnArray[697] = (Button)findViewById(R.id.btn697);
    btnArray[698] = (Button)findViewById(R.id.btn698);
    btnArray[699] = (Button)findViewById(R.id.btn699);
    btnArray[700] = (Button)findViewById(R.id.btn700);

    btnArray[701] = (Button)findViewById(R.id.btn701);
    btnArray[702] = (Button)findViewById(R.id.btn702);
    btnArray[703] = (Button)findViewById(R.id.btn703);
    btnArray[704] = (Button)findViewById(R.id.btn704);
    btnArray[705] = (Button)findViewById(R.id.btn705);
    btnArray[706] = (Button)findViewById(R.id.btn706);
    btnArray[707] = (Button)findViewById(R.id.btn707);
    btnArray[708] = (Button)findViewById(R.id.btn708);
    btnArray[709] = (Button)findViewById(R.id.btn709);
    btnArray[710] = (Button)findViewById(R.id.btn710);
    btnArray[711] = (Button)findViewById(R.id.btn711);
    btnArray[712] = (Button)findViewById(R.id.btn712);
    btnArray[713] = (Button)findViewById(R.id.btn713);
    btnArray[714] = (Button)findViewById(R.id.btn714);
    btnArray[715] = (Button)findViewById(R.id.btn715);
    btnArray[716] = (Button)findViewById(R.id.btn716);
    btnArray[717] = (Button)findViewById(R.id.btn717);
    btnArray[718] = (Button)findViewById(R.id.btn718);
    btnArray[719] = (Button)findViewById(R.id.btn719);
    btnArray[720] = (Button)findViewById(R.id.btn720);
    btnArray[721] = (Button)findViewById(R.id.btn721);
    btnArray[722] = (Button)findViewById(R.id.btn722);
    btnArray[723] = (Button)findViewById(R.id.btn723);
    btnArray[724] = (Button)findViewById(R.id.btn724);
    btnArray[725] = (Button)findViewById(R.id.btn725);
    btnArray[726] = (Button)findViewById(R.id.btn726);
    btnArray[727] = (Button)findViewById(R.id.btn727);
    btnArray[728] = (Button)findViewById(R.id.btn728);
    btnArray[729] = (Button)findViewById(R.id.btn729);
    btnArray[730] = (Button)findViewById(R.id.btn730);
    btnArray[731] = (Button)findViewById(R.id.btn731);
    btnArray[732] = (Button)findViewById(R.id.btn732);
    btnArray[733] = (Button)findViewById(R.id.btn733);
    btnArray[734] = (Button)findViewById(R.id.btn734);
    btnArray[735] = (Button)findViewById(R.id.btn735);
    btnArray[736] = (Button)findViewById(R.id.btn736);
    btnArray[737] = (Button)findViewById(R.id.btn737);
    btnArray[738] = (Button)findViewById(R.id.btn738);
    btnArray[739] = (Button)findViewById(R.id.btn739);
    btnArray[740] = (Button)findViewById(R.id.btn740);
    btnArray[741] = (Button)findViewById(R.id.btn741);
    btnArray[742] = (Button)findViewById(R.id.btn742);
    btnArray[743] = (Button)findViewById(R.id.btn743);
    btnArray[744] = (Button)findViewById(R.id.btn744);
    btnArray[745] = (Button)findViewById(R.id.btn745);
    btnArray[746] = (Button)findViewById(R.id.btn746);
    btnArray[747] = (Button)findViewById(R.id.btn747);
    btnArray[748] = (Button)findViewById(R.id.btn748);
    btnArray[749] = (Button)findViewById(R.id.btn749);
    btnArray[750] = (Button)findViewById(R.id.btn750);
    btnArray[751] = (Button)findViewById(R.id.btn751);
    btnArray[752] = (Button)findViewById(R.id.btn752);
    btnArray[753] = (Button)findViewById(R.id.btn753);
    btnArray[754] = (Button)findViewById(R.id.btn754);
    btnArray[755] = (Button)findViewById(R.id.btn755);
    btnArray[756] = (Button)findViewById(R.id.btn756);
    btnArray[757] = (Button)findViewById(R.id.btn757);
    btnArray[758] = (Button)findViewById(R.id.btn758);
    btnArray[759] = (Button)findViewById(R.id.btn759);
    btnArray[760] = (Button)findViewById(R.id.btn760);
    btnArray[761] = (Button)findViewById(R.id.btn761);
    btnArray[762] = (Button)findViewById(R.id.btn762);
    btnArray[763] = (Button)findViewById(R.id.btn763);
    btnArray[764] = (Button)findViewById(R.id.btn764);
    btnArray[765] = (Button)findViewById(R.id.btn765);
    btnArray[766] = (Button)findViewById(R.id.btn766);
    btnArray[767] = (Button)findViewById(R.id.btn767);
    btnArray[768] = (Button)findViewById(R.id.btn768);
    btnArray[769] = (Button)findViewById(R.id.btn769);
    btnArray[770] = (Button)findViewById(R.id.btn770);
    btnArray[771] = (Button)findViewById(R.id.btn771);
    btnArray[772] = (Button)findViewById(R.id.btn772);
    btnArray[773] = (Button)findViewById(R.id.btn773);
    btnArray[774] = (Button)findViewById(R.id.btn774);
    btnArray[775] = (Button)findViewById(R.id.btn775);
    btnArray[776] = (Button)findViewById(R.id.btn776);
    btnArray[777] = (Button)findViewById(R.id.btn777);
    btnArray[778] = (Button)findViewById(R.id.btn778);
    btnArray[779] = (Button)findViewById(R.id.btn779);
    btnArray[780] = (Button)findViewById(R.id.btn780);
    btnArray[781] = (Button)findViewById(R.id.btn781);
    btnArray[782] = (Button)findViewById(R.id.btn782);
    btnArray[783] = (Button)findViewById(R.id.btn783);
    btnArray[784] = (Button)findViewById(R.id.btn784);
    btnArray[785] = (Button)findViewById(R.id.btn785);
    btnArray[786] = (Button)findViewById(R.id.btn786);
    btnArray[787] = (Button)findViewById(R.id.btn787);
    btnArray[788] = (Button)findViewById(R.id.btn788);
    btnArray[789] = (Button)findViewById(R.id.btn789);
    btnArray[790] = (Button)findViewById(R.id.btn790);
    btnArray[791] = (Button)findViewById(R.id.btn791);
    btnArray[792] = (Button)findViewById(R.id.btn792);
    btnArray[793] = (Button)findViewById(R.id.btn793);
    btnArray[794] = (Button)findViewById(R.id.btn794);
    btnArray[795] = (Button)findViewById(R.id.btn795);
    btnArray[796] = (Button)findViewById(R.id.btn796);
    btnArray[797] = (Button)findViewById(R.id.btn797);
    btnArray[798] = (Button)findViewById(R.id.btn798);
    btnArray[799] = (Button)findViewById(R.id.btn799);
    btnArray[800] = (Button)findViewById(R.id.btn800);

    btnArray[801] = (Button)findViewById(R.id.btn801);
    btnArray[802] = (Button)findViewById(R.id.btn802);
    btnArray[803] = (Button)findViewById(R.id.btn803);
    btnArray[804] = (Button)findViewById(R.id.btn804);
    btnArray[805] = (Button)findViewById(R.id.btn805);
    btnArray[806] = (Button)findViewById(R.id.btn806);
    btnArray[807] = (Button)findViewById(R.id.btn807);
    btnArray[808] = (Button)findViewById(R.id.btn808);
    btnArray[809] = (Button)findViewById(R.id.btn809);
    btnArray[810] = (Button)findViewById(R.id.btn810);
    btnArray[811] = (Button)findViewById(R.id.btn811);
    btnArray[812] = (Button)findViewById(R.id.btn812);
    btnArray[813] = (Button)findViewById(R.id.btn813);
    btnArray[814] = (Button)findViewById(R.id.btn814);
    btnArray[815] = (Button)findViewById(R.id.btn815);
    btnArray[816] = (Button)findViewById(R.id.btn816);
    btnArray[817] = (Button)findViewById(R.id.btn817);
    btnArray[818] = (Button)findViewById(R.id.btn818);
    btnArray[819] = (Button)findViewById(R.id.btn819);
    btnArray[820] = (Button)findViewById(R.id.btn820);
    btnArray[821] = (Button)findViewById(R.id.btn821);
    btnArray[822] = (Button)findViewById(R.id.btn822);
    btnArray[823] = (Button)findViewById(R.id.btn823);
    btnArray[824] = (Button)findViewById(R.id.btn824);
    btnArray[825] = (Button)findViewById(R.id.btn825);
    btnArray[826] = (Button)findViewById(R.id.btn826);
    btnArray[827] = (Button)findViewById(R.id.btn827);
    btnArray[828] = (Button)findViewById(R.id.btn828);
    btnArray[829] = (Button)findViewById(R.id.btn829);
    btnArray[830] = (Button)findViewById(R.id.btn830);
    btnArray[831] = (Button)findViewById(R.id.btn831);
    btnArray[832] = (Button)findViewById(R.id.btn832);
    btnArray[833] = (Button)findViewById(R.id.btn833);
    btnArray[834] = (Button)findViewById(R.id.btn834);
    btnArray[835] = (Button)findViewById(R.id.btn835);
    btnArray[836] = (Button)findViewById(R.id.btn836);
    btnArray[837] = (Button)findViewById(R.id.btn837);
    btnArray[838] = (Button)findViewById(R.id.btn838);
    btnArray[839] = (Button)findViewById(R.id.btn839);
    btnArray[840] = (Button)findViewById(R.id.btn840);
    btnArray[841] = (Button)findViewById(R.id.btn841);
    btnArray[842] = (Button)findViewById(R.id.btn842);
    btnArray[843] = (Button)findViewById(R.id.btn843);
    btnArray[844] = (Button)findViewById(R.id.btn844);
    btnArray[845] = (Button)findViewById(R.id.btn845);
    btnArray[846] = (Button)findViewById(R.id.btn846);
    btnArray[847] = (Button)findViewById(R.id.btn847);
    btnArray[848] = (Button)findViewById(R.id.btn848);
    btnArray[849] = (Button)findViewById(R.id.btn849);
    btnArray[850] = (Button)findViewById(R.id.btn850);
    btnArray[851] = (Button)findViewById(R.id.btn851);
    btnArray[852] = (Button)findViewById(R.id.btn852);
    btnArray[853] = (Button)findViewById(R.id.btn853);
    btnArray[854] = (Button)findViewById(R.id.btn854);
    btnArray[855] = (Button)findViewById(R.id.btn855);
    btnArray[856] = (Button)findViewById(R.id.btn856);
    btnArray[857] = (Button)findViewById(R.id.btn857);
    btnArray[858] = (Button)findViewById(R.id.btn858);
    btnArray[859] = (Button)findViewById(R.id.btn859);
    btnArray[860] = (Button)findViewById(R.id.btn860);
    btnArray[861] = (Button)findViewById(R.id.btn861);
    btnArray[862] = (Button)findViewById(R.id.btn862);
    btnArray[863] = (Button)findViewById(R.id.btn863);
    btnArray[864] = (Button)findViewById(R.id.btn864);
    btnArray[865] = (Button)findViewById(R.id.btn865);
    btnArray[866] = (Button)findViewById(R.id.btn866);
    btnArray[867] = (Button)findViewById(R.id.btn867);
    btnArray[868] = (Button)findViewById(R.id.btn868);
    btnArray[869] = (Button)findViewById(R.id.btn869);
    btnArray[870] = (Button)findViewById(R.id.btn870);
    btnArray[871] = (Button)findViewById(R.id.btn871);
    btnArray[872] = (Button)findViewById(R.id.btn872);
    btnArray[873] = (Button)findViewById(R.id.btn873);
    btnArray[874] = (Button)findViewById(R.id.btn874);
    btnArray[875] = (Button)findViewById(R.id.btn875);
    btnArray[876] = (Button)findViewById(R.id.btn876);
    btnArray[877] = (Button)findViewById(R.id.btn877);
    btnArray[878] = (Button)findViewById(R.id.btn878);
    btnArray[879] = (Button)findViewById(R.id.btn879);
    btnArray[880] = (Button)findViewById(R.id.btn880);
    btnArray[881] = (Button)findViewById(R.id.btn881);
    btnArray[882] = (Button)findViewById(R.id.btn882);
    btnArray[883] = (Button)findViewById(R.id.btn883);
    btnArray[884] = (Button)findViewById(R.id.btn884);
    btnArray[885] = (Button)findViewById(R.id.btn885);
    btnArray[886] = (Button)findViewById(R.id.btn886);
    btnArray[887] = (Button)findViewById(R.id.btn887);
    btnArray[888] = (Button)findViewById(R.id.btn888);
    btnArray[889] = (Button)findViewById(R.id.btn889);
    btnArray[890] = (Button)findViewById(R.id.btn890);
    btnArray[891] = (Button)findViewById(R.id.btn891);
    btnArray[892] = (Button)findViewById(R.id.btn892);
    btnArray[893] = (Button)findViewById(R.id.btn893);
    btnArray[894] = (Button)findViewById(R.id.btn894);
    btnArray[895] = (Button)findViewById(R.id.btn895);
    btnArray[896] = (Button)findViewById(R.id.btn896);
    btnArray[897] = (Button)findViewById(R.id.btn897);
    btnArray[898] = (Button)findViewById(R.id.btn898);
    btnArray[899] = (Button)findViewById(R.id.btn899);
    btnArray[900] = (Button)findViewById(R.id.btn900);

    uhandler = UserDBHandler.open(getApplicationContext());
    ucursor = uhandler.selectAll();

    if(ucursor != null && ucursor.getCount() != 0) {
      ucursor.moveToFirst();

      do {

        int start_time = Integer.parseInt(ucursor.getString(2));
        int end_time = Integer.parseInt(ucursor.getString(3));
        String name = ucursor.getString(4);
        String color = ucursor.getString(5);

        int interval = end_time - start_time + 1;

        final int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float)2.5*interval, getResources().getDisplayMetrics());
        android.view.ViewGroup.LayoutParams layoutParams = btnArray[start_time].getLayoutParams();
        //btnArray[start_time].setLayoutParams(new LinearLayout.LayoutParams(width, height));
        layoutParams.height = height;
        btnArray[start_time].setLayoutParams(layoutParams);

        btnArray[start_time].setBackgroundColor(Color.parseColor(color));
        btnArray[start_time].setText(name);
        btnArray[start_time].setTextSize(10);

        for(int i = start_time+1; i <= end_time; i++)
          btnArray[i].setVisibility(View.GONE);

      } while (ucursor.moveToNext());
    }

    ArrayList<MainTimeDTO> mainTimeList = new ArrayList<MainTimeDTO>();

    mainTimeList.add(new MainTimeDTO(""));
    mainTimeList.add(new MainTimeDTO("7~8"));
    mainTimeList.add(new MainTimeDTO("8~9"));
    mainTimeList.add(new MainTimeDTO("9~10"));
    mainTimeList.add(new MainTimeDTO("10~11"));
    mainTimeList.add(new MainTimeDTO("11~12"));
    mainTimeList.add(new MainTimeDTO("12~13"));
    mainTimeList.add(new MainTimeDTO("13~14"));
    mainTimeList.add(new MainTimeDTO("14~15"));
    mainTimeList.add(new MainTimeDTO("15~16"));
    mainTimeList.add(new MainTimeDTO("16~17"));
    mainTimeList.add(new MainTimeDTO("17~18"));
    mainTimeList.add(new MainTimeDTO("18~19"));
    mainTimeList.add(new MainTimeDTO("19~20"));
    mainTimeList.add(new MainTimeDTO("20~21"));
    mainTimeList.add(new MainTimeDTO("21~22"));

    mainTimeListView = (ListView)findViewById(R.id.main_time_listview);
    mainTimeListView.setDivider(null);

    MainTimeAdapter mainTimeAdapter = new MainTimeAdapter(getApplicationContext(), R.layout.main_time_list_row, mainTimeList);

    mainTimeListView.setAdapter(mainTimeAdapter);

    startActivity(new Intent(this, SplashActivity.class));
  }

  public void onClick(View v) {
    switch(v.getId()) {

      case R.id.main_edit_btn:
        createEditDialog();
        break;

      case R.id.main_del_btn:
        createDelDialog();
        break;

      case R.id.main_add_frn_btn:
        break;

      default:
        break;
    }
  }

  /* 시간표 선택 버튼 */
  private OnClickListener selTtabClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
      Intent intent = new Intent(getApplicationContext(), SelTtabActivity.class);
      startActivityForResult(intent, 1);
    }
  };

  /* 스케줄 작성 버튼 */
  private OnClickListener wrSchdlClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
      Intent intent = new Intent(getApplicationContext(), WrSchdlActivity.class);
      startActivityForResult(intent, 1);
    }
  };

  /* 시간표 선택 삭제 버튼 */
  private OnClickListener delTtabClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
      Intent intent = new Intent(getApplicationContext(), SelTtabActivity.class);
      startActivityForResult(intent, 1);
    }
  };

  /* 일정 선택 삭제 버튼 */
  private OnClickListener delSchdlClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
      Intent intent = new Intent(getApplicationContext(), ShowSchdlActivity.class);
      startActivityForResult(intent, 1);
    }
  };

  /* 시간표 전체 삭제 버튼 */
  private OnClickListener delEntireTtabClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
      createDelEntireTtabDialog();
    }
  };

  /* 시간표 전체 삭제 버튼(두 번째 다이얼로그) */
  private OnClickListener deleteEntireTtabClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
      uhandler.deleteLtCode("100");
      delEntireTtabDialog.dismiss();
    }
  };

  /* 시간표 전체 삭제 취소 버튼(두 번째 다이얼로그) */
  private OnClickListener cancelEntireTtabClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
      delEntireTtabDialog.dismiss();
    }
  };

  /* 일정 전체 삭제 버튼 */
  private OnClickListener delEntireSchdlClickListener = new OnClickListener() {
    @Override
    public void onClick(View view) {
      createDelEntireSchdlDialog();
    }
  };

  /* 일정 전체 삭제 버튼(두 번째 다이얼로그) */
  private OnClickListener deleteEntireSchdlClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
      uhandler.deleteByCode("100");
      delEntireSchdlDialog.dismiss();
    }
  };

  /* 일정 전체 삭제 취소 버튼(두 번째 다이얼로그) */
  private OnClickListener cancelEntireSchdlClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
      delEntireSchdlDialog.dismiss();
    }
  };

  /* 전체 삭제 버튼 */
  private OnClickListener delEntireClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
      createDelEntireDialog();
    }
  };

  /* 전체 삭제 버튼(두 번째 다이얼로그) */
  private OnClickListener deleteEntireClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
      uhandler.delete();
      delEntireDialog.dismiss();
    }
  };

  /* 전체 삭제 취소 버튼(두 번째 다이얼로그) */
  private OnClickListener cancelEntireClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
      delEntireDialog.dismiss();
    }
  };

  /* 편집 다이얼로그 */
  private void createEditDialog() {
    final View innerView = getLayoutInflater().inflate(R.layout.edit_sel_dialog, null);

    editSelDialog = new EditSelDialog(this, selTtabClickListener, wrSchdlClickListener);
    editSelDialog.show();
  }

  /* 삭제 다이얼로그 */
  private void createDelDialog() {
    final View innerView = getLayoutInflater().inflate(R.layout.del_sel_dialog, null);

    delSelDialog = new DelSelDialog(this, delTtabClickListener, delSchdlClickListener
        , delEntireTtabClickListener, delEntireSchdlClickListener, delEntireClickListener);
    delSelDialog.show();
  }

  /* 시간표 전체 삭제 다이얼로그 */
  private void createDelEntireTtabDialog() {
    final View innerView = getLayoutInflater().inflate(R.layout.del_entire_ttab_dialog, null);

    delEntireTtabDialog = new DelEntireTtabDialog(this, deleteEntireTtabClickListener, cancelEntireTtabClickListener);
    delEntireTtabDialog.show();
  }

  /* 일정 전체 삭제 다이얼로그 */
  private void createDelEntireSchdlDialog() {
    final View innerView = getLayoutInflater().inflate(R.layout.del_entire_schdl_dialog, null);

    delEntireSchdlDialog = new DelEntireSchdlDialog(this, deleteEntireSchdlClickListener, cancelEntireSchdlClickListener);
    delEntireSchdlDialog.show();
  }

  /* 전체 삭제 다이얼로그 */
  private void createDelEntireDialog() {
    final View innerView = getLayoutInflater().inflate(R.layout.del_entire_dialog, null);

    delEntireDialog = new DelEntireDialog(this, deleteEntireClickListener, cancelEntireClickListener);
    delEntireDialog.show();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
