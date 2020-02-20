$(document).ready(function() {
    $('#birthday').datepicker({
        autoclose: true,
        todayHighlight: true
    });
});
$(document).ready(function() {
    $(".panel-heading").html('<b>All Orders </b><button id="refresh">Refresh</button>');
    $('#refresh').on('click', loadOrders);
    var table = $("#orders").DataTable({
        "responsive" : true,
        "ajax":{
            url: "orders/all",
            dataType : "json",
            type: "GET",
            "data": function(d){
            },
            dataSrc:'',
        },
        "columns": [
            { "data": "orderId"},
            { "data": "userEmail"},
            { "data": "tourName",
            	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                		if(oData.tourId == "0"){
                			 $(nTd).html("None");
                		}else{
                			 $(nTd).html("<a href='dashboard/tour?id="+oData.tourId+"'>"+oData.tourName+"</a>");
                			}
                    	},
                "defaultContent": "<i>Not set</i>"
            },
            { "data": "tourPrice"},
            { "data": "flightId",
            	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
            		if(oData.flightPrice == 0){
            			 $(nTd).html("None");
            		}else{
            			 $(nTd).html("<a href='dashboard/flight?id="+oData.flightId+"'>"+oData.flightId+"</a>");
            			}
                	},
              "defaultContent": "<i>Not set</i>"
            },
            { "data": "flightPrice",
               "defaultContent": "<i>Not set</i>"
            },
            { "data": "hotelId",
            	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
            		if(oData.hotelPrice == "0"){
            			 $(nTd).html("None");
            		}else{
            			 $(nTd).html("<a href='dashboard/hotel?id="+oData.hotelId+"'>"+oData.hotelId+"</a>");
            			}
                	},
                "defaultContent": "<i>Not set</i>"
            },	
            { "data": "hotelPrice",
                "defaultContent": "<i>Not set</i>"
            	
            },
            { "data": "rentalId",
            	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
            		if(oData.rentalPrice == 0){
            			 $(nTd).html("None");
            		}else{
            			 $(nTd).html("<a href='dashboard/rental?id="+oData.rentalId+"'>"+oData.rentalId+"</a>");
            			}
                	}
            },
            { "data": "rentalPrice",
                "defaultContent": "<i>Not set</i>"},
            {
                "data": function(data, type) {
                    return "<button class='delete btn btn-danger btn-sm'>Delete</button>";
                },
                "bSortable": false
            }
        ],
        "bDestroy": true

    }).on( 'click', '.delete', function () {
        var orderId = $("#orders").DataTable().row($(this).closest('tr')).data().orderId;
        var url = "update/order?id="+ orderId + "&delete=true";
        var deleteUser = confirm("Are you shure you want to delete the order #" + orderId + "?");
        if(deleteUser){
            $.ajax({
                url : url,
                type: "DELETE",
                success: function (data) {
                	loadOrders();
                },
                error: function (jXHR, textStatus, errorThrown) {
                    alert(textStatus);
                }
            });
        }
    });
});

function loadOrders(){
    var table = $("#orders").DataTable({
        "responsive" : true,
        "ajax":{
            url: "orders/all",
            dataType : "json",
            type: "GET",
            "data": function(d){
            },
            dataSrc:'',
        },
        "columns": [
            { "data": "orderId"},
            { "data": "userEmail"},
            { "data": "tourName",
            	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                		if(oData.tourId == "0"){
                			 $(nTd).html("None");
                		}else{
                			 $(nTd).html("<a href='dashboard/tour?id="+oData.tourId+"'>"+oData.tourName+"</a>");
                			}
                    	},
                "defaultContent": "<i>Not set</i>"
            },
            { "data": "tourPrice"},
            { "data": "flightId",
            	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
            		if(oData.flightPrice == 0){
            			 $(nTd).html("None");
            		}else{
            			 $(nTd).html("<a href='dashboard/flight?id="+oData.flightId+"'>"+oData.flightId+"</a>");
            			}
                	},
              "defaultContent": "<i>Not set</i>"
            },
            { "data": "flightPrice",
               "defaultContent": "<i>Not set</i>"
            },
            { "data": "hotelId",
            	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
            		if(oData.hotelPrice == "0"){
            			 $(nTd).html("None");
            		}else{
            			 $(nTd).html("<a href='dashboard/hotel?id="+oData.hotelId+"'>"+oData.hotelId+"</a>");
            			}
                	},
                "defaultContent": "<i>Not set</i>"
            },	
            { "data": "hotelPrice",
                "defaultContent": "<i>Not set</i>"
            	
            },
            { "data": "rentalId",
            	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
            		if(oData.rentalPrice == 0){
            			 $(nTd).html("None");
            		}else{
            			 $(nTd).html("<a href='dashboard/rental?id="+oData.rentalId+"'>"+oData.rentalId+"</a>");
            			}
                	}
            },
            { "data": "rentalPrice",
                "defaultContent": "<i>Not set</i>"},
            {
                "data": function(data, type) {
                    return "<button class='delete btn btn-danger btn-sm'>Delete</button>";
                },
                "bSortable": false
            }
        ],
        "bDestroy": true
    });
}


