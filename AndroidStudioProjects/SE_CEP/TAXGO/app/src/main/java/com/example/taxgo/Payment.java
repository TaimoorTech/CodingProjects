package com.example.taxgo;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;
import com.itextpdf.kernel.colors.WebColors;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Payment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Payment extends Fragment {

    TextInputLayout SelectType,Year,Month;

    EditText CardNumber,ExpiryDate,Cvv,Name,Amount;
    NavigationView navigation;
    Button btn;
    MenuItem menuItem;

    AutoCompleteTextView Tax_Type,Tax_Year,Tax_month;

    AlertDialog.Builder builder;
    String server_url = "http://192.168.2.4/project/payment.php";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Payment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TransactionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Payment newInstance(String param1, String param2) {
        Payment fragment = new Payment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void printPDF() throws FileNotFoundException {

        ArrayList<String> description = new ArrayList<>();
        ArrayList<String> amount = new ArrayList<>();

        description.add("Total Income");
        description.add("TAX Income");

        amount.add("363753");
        amount.add("363753");

        String date = new SimpleDateFormat("dd/LLL/yyyy", Locale.getDefault()).format(new Date()).toString();
        String time = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date()).toString();
        String period="08-Jan-2023 - 10-Jan-2024";
        String medium="Online";
        String due_date="15-Jan-2024";
        String valid_upto="10-Jan-2024";


        String pdf_path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        File file = new File(pdf_path, "Transaction_Report.pdf");
        OutputStream outputStream = new FileOutputStream(file);

        PdfWriter pdfWriter = new PdfWriter(file);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        float columnWidth[] = {360};
        Table table = new Table(columnWidth);
        table.addCell(new Cell().add(new Paragraph("Transaction Report").setFontSize(20).setBold()).setBorder(Border.NO_BORDER));

        float columnWidth1[] = {120, 220};
        Table table1 = new Table(columnWidth1);

        table1.addCell(new Cell().add(new Paragraph("TAX Year:").setFontSize(14).
                setBorder(Border.NO_BORDER)));
        table1.addCell(new Cell().add(new Paragraph(date).setFontSize(14).setBorder(Border.NO_BORDER)));

        table1.addCell(new Cell().add(new Paragraph("Document Date: ").setFontSize(14).setBorder(Border.NO_BORDER)));
        table1.addCell(new Cell().add(new Paragraph(date).setFontSize(14).setBorder(Border.NO_BORDER)));

        table1.addCell(new Cell().add(new Paragraph("Time: ").setFontSize(14).setBorder(Border.NO_BORDER)));
        table1.addCell(new Cell().add(new Paragraph(time).setFontSize(14).setBorder(Border.NO_BORDER)));

        table1.addCell(new Cell().add(new Paragraph("Period: ").setFontSize(14).setBorder(Border.NO_BORDER)));
        table1.addCell(new Cell().add(new Paragraph(period).setFontSize(14).setBorder(Border.NO_BORDER)));

        table1.addCell(new Cell().add(new Paragraph("Medium: ").setFontSize(14).setBorder(Border.NO_BORDER)));
        table1.addCell(new Cell().add(new Paragraph(medium).setFontSize(14).setBorder(Border.NO_BORDER)));

        table1.addCell(new Cell().add(new Paragraph("Due Date: ").setFontSize(14).setBorder(Border.NO_BORDER)));
        table1.addCell(new Cell().add(new Paragraph(due_date).setFontSize(14).setBorder(Border.NO_BORDER)));

        table1.addCell(new Cell().add(new Paragraph("Valid Upto: ").setFontSize(14).setBorder(Border.NO_BORDER)));
        table1.addCell(new Cell().add(new Paragraph(valid_upto).setFontSize(14).setBorder(Border.NO_BORDER)));

        float columnWidth2[] = {350, 200};
        Table table2 = new Table(columnWidth2);

        table2.addCell(new Cell().add(new Paragraph("Description")
                .setTextAlignment(TextAlignment.CENTER)
                .setBold()
                .setBackgroundColor(WebColors.getRGBColor("#FFFFFF"))
                .setFontColor(WebColors.getRGBColor("#3ab54c"))));
        table2.addCell(new Cell().add(new Paragraph("  Amount (Rs.)")
                .setTextAlignment(TextAlignment.CENTER)
                .setBold()
                .setBackgroundColor(WebColors.getRGBColor("#FFFFFF"))
                .setFontColor(WebColors.getRGBColor("#3ab54c"))));

        for (int i=0; i<description.size(); i++) {
            table2.addCell(new Cell().add(new Paragraph(description.get(i))));
            table2.addCell(new Cell().add(new Paragraph(amount.get(i)).setTextAlignment(TextAlignment.RIGHT)));
        }

        document.add(table);
        document.add(new Paragraph("\n"));
        document.add(table1);
        document.add(new Paragraph("\n"));
        document.add(table2);
        document.close();

        Toast.makeText(getActivity(), "Successfully Created", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onResume() {
        super.onResume();

        if(getActivity()!=null) {
            ((MainActivity) getActivity()).setActionBarTitle("Payment");
        }

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keycode, KeyEvent keyEvent) {

                if (keyEvent.getAction() == KeyEvent.ACTION_UP && keycode == KeyEvent.KEYCODE_BACK){
                    Menu drawer_menu = navigation.getMenu();
                    MenuItem menuItem = drawer_menu.findItem(R.id.transaction);
                    menuItem.setChecked(false);
                    getActivity().onBackPressed();
                    return true;
                }

                return false;
            }
        });

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_payment, container, false);

        SelectType = view.findViewById(R.id.select_type_TextInputLayout);
        Year = view.findViewById(R.id.year_TextInputLayout);
        Month = view.findViewById(R.id.month_TextInputLayout);

        CardNumber = view.findViewById(R.id.card_number_edittext);
        ExpiryDate = view.findViewById(R.id.expiry_date_edittext);
        Cvv = view.findViewById(R.id.cvv_edittext);
        Name = view.findViewById(R.id.name_edittext);
        Amount = view.findViewById(R.id.amount_edittext);

        btn = view.findViewById(R.id.pay_now_button);

        builder = new AlertDialog.Builder(requireActivity(), R.style.MyAlertDialogStyle);


        navigation = getActivity().findViewById(R.id.nav_view);

        Menu drawer_menu = navigation.getMenu();
        menuItem = drawer_menu.findItem(R.id.home);

        MenuItem menuItem1 = drawer_menu.findItem(R.id.home);
        MenuItem menuItem2 = drawer_menu.findItem(R.id.transaction);
        MenuItem menuItem3 = drawer_menu.findItem(R.id.History);
        MenuItem menuItem4 = drawer_menu.findItem(R.id.about_us);
        MenuItem menuItem5 = drawer_menu.findItem(R.id.view_profile);
        MenuItem menuItem6 = drawer_menu.findItem(R.id.faq);

        menuItem.setChecked(false);
        menuItem1.setChecked(false);
        menuItem2.setChecked(false);
        menuItem3.setChecked(false);
        menuItem4.setChecked(false);
        menuItem5.setChecked(false);
        menuItem6.setChecked(false);

        if(!menuItem2.isChecked()){
            menuItem2.setChecked(true);
        }

        Tax_Type = view.findViewById(R.id.select_type_autoComplete);

        //We will use this data to inflate the drop-down items
        String[] tax_type_list = new String[]{"Property", "Vehicle"};

        // create an array adapter and pass the required parameter
        // in our case pass the context, drop down layout , and array.
        ArrayAdapter<String> tax_type = new ArrayAdapter<>(getActivity(), R.layout.dropdown_item, tax_type_list);
        Tax_Type.setAdapter(tax_type);

        Tax_Year = view.findViewById(R.id.year_autoComplete);

        //We will use this data to inflate the drop-down items
        String[] year_list = new String[]{"2023", "2022", "2021", "2020", "2019"};

        // create an array adapter and pass the required parameter
        // in our case pass the context, drop down layout , and array.
        ArrayAdapter<String> year = new ArrayAdapter<>(getActivity(), R.layout.dropdown_item, year_list);
        Tax_Year.setAdapter(year);

        Tax_month = view.findViewById(R.id.month_autoComplete);

        //We will use this data to inflate the drop-down items
        String[] month_list = new String[]{"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};

        // create an array adapter and pass the required parameter
        // in our case pass the context, drop down layout , and array.
        ArrayAdapter<String> month = new ArrayAdapter<>(getActivity(), R.layout.dropdown_item, month_list);
        Tax_month.setAdapter(month);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Payment_Func();
            }
        });

        return view;
    }
    public void Payment_Func(){

        final String select_type = SelectType.getEditText().getText().toString();
        final String year = Year.getEditText().getText().toString();
        final String month = Month.getEditText().getText().toString();


        final String card_number = CardNumber.getText().toString();
        final String expiry_date = ExpiryDate.getText().toString();
        final String cvv = Cvv.getText().toString();
        final String name = Name.getText().toString();
        final String amount = Amount.getText().toString();


        if(!select_type.isEmpty() && !year.isEmpty()  && !month.isEmpty() && !name.isEmpty()){
            if(card_number.length() == 16){
                if(cvv.length() == 3){
                    if(expiry_date.matches("([0-9]{2})/([0-9]{4})") && (expiry_date.startsWith("0") ||
                            expiry_date.startsWith("1"))) {
                        if (amount.length() >= 4) {
                            StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url, response -> {

                                builder = new MaterialAlertDialogBuilder(requireActivity(), R.style.MyAlertDialogStyle)

                                        .setTitle("Server Response")
                                        .setMessage("Response :"+response)
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                                Tax_Type.setText("");
                                                Tax_Year.setText("");
                                                Tax_month.setText("");
                                                CardNumber.setText("");
                                                ExpiryDate.setText("");
                                                Cvv.setText("");
                                                Name.setText("");
                                                Amount.setText("");

                                                dialog.dismiss();
                                            }
                                        })
                                        .setNegativeButton("close", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        });
                                builder.create();
                                builder.show();
                            }

                                    , error -> {
                                Toast.makeText(requireActivity(), "some error occurred .....", Toast.LENGTH_SHORT).show();
                                error.printStackTrace();

                            }) {
                                @Override
                                protected Map<String, String> getParams() {
                                    Map<String, String> Params = new HashMap<>();

                                    Params.put("tax_type", select_type);
                                    Params.put("year", year);
                                    Params.put("month", month);

                                    Params.put("card_number", card_number);
                                    Params.put("expiry_date", expiry_date);
                                    Params.put("cvv", cvv);
                                    Params.put("name", name);
                                    Params.put("amount", amount);

                                    return Params;

                                }
                            };
                            My_Singleton.getInstance(requireActivity()).addToRequestQue(stringRequest);



                        }
                        else{
                            Toast.makeText(requireActivity(), "invalid amount", Toast.LENGTH_SHORT).show();
                        }
                    }

                    else{
                    Toast.makeText(requireActivity(), "invalid expiry date", Toast.LENGTH_SHORT).show();
                    }
                }

                else{
                    Toast.makeText(requireActivity(), "invalid cvv", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(requireActivity(), "invalid card number", Toast.LENGTH_SHORT).show();
            }
        }

        else{
            Toast.makeText(getActivity(), "field can't be empty", Toast.LENGTH_SHORT).show();
        }
    }
}