<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Medical Declaration</title>
</head>
<body>
<h2 style="text-align: center">TỜ KHAI Y TẾ</h2>
<h3 style="text-align: center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Ý TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h3>
<h4 style="text-align: center; color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</h4>
<form:form action="user" modelAttribute="form" method="post">
    <div class="row">
        <label>Họ tên</label><br>
        <form:input path="name" required="required"/>
    </div>
    <div class="row">
        <table>
            <tr>
                <th>Năm sinh</th>
                <th>Giới tính</th>
                <th>Quốc tịch</th>
            </tr>
            <tr>
                <td><form:input type="number" path="year"  required="required"/></td>
                <td><form:input path="gender" required="required" /></td>
                <td><form:input path="national" required="required"/></td>
            </tr>
        </table>
    </div>
    <div class="row">
        <p>Hộ chiếu, CMND: </p>
        <form:input type="number" path="identity"/>
    </div>
    <div class="row">
        <p>Thông tin đi lại</p>
        <p>
            <form:radiobutton path="vehicle" value="Tàu bay" label="Tàu bay" required="required"/>
            <form:radiobutton path="vehicle" value="Tàu thuyền" label="Tàu thuyền" required="required"/>
            <form:radiobutton path="vehicle" value="Ô tô" label="Ô tô" required="required"/>
            <form:radiobutton path="vehicle" value="Khác" label="Khác" required="required"/>
        </p>
    </div>
    <div class="row">
        <table>
            <tr>
                <th>Số hiệu phương tiện</th>
                <th>Số ghế</th>
            </tr>
            <tr>
                <td><form:input path="plate" label="VD:VN123"/></td>
                <td><form:input path="chair"/></td>
            </tr>
        </table>
    </div>
    <div class="row">
        <table>
            <tr>
                <th>Ngày khởi hành</th>
                <th>Ngày kết thúc</th>
            </tr>
            <tr>
                <td><form:input type="date" path="datebegin" required="required"/></td>
                <td><form:input type="date" path="dateend" required="required"/></td>
            </tr>
        </table>
    </div>
    <div class="row">
        <p>Các anh chị đã đi đâu trong 14 ngày qua</p>
        <form:textarea path="history" required="required"/>
    </div>
    <div class="row">
        <table>
            <tr>
                <th>Thành phố</th>
                <th>Quận/Huyện</th>
                <th>Xã/Phường</th>
            </tr>
            <tr>
                <td><form:input path="city" required="required"/></td>
                <td><form:input path="district" required="required"/></td>
                <td><form:input path="ward" required="required"/></td>
            </tr>
        </table>
    </div>
    <div class="row">
        <p>Địa chỉ nơi ở</p>
        <form:input path="address" required="required"/>
    </div>
    <div class="row">
        <table>
            <tr>
                <th>Điện thoại</th>
                <th>Email</th>
            </tr>
            <tr>
                <td><form:input type="number" path="tel" required="required"/></td>
                <td><form:input path="mail"/></td>
            </tr>
        </table>
    </div>
    <div class="row">
        <p>Trong vòng 14 ngày qua , anh/chị có dấu hiêu gì không</p>
        <table>
            <tr>
                <th>Triệu chứng</th>
                <th>Có</th>
                <th>Không</th>
                <th>Triệu chứng</th>
                <th>Có</th>
                <th>Không</th>
            </tr>
            <tr>
                <td>Sốt</td>
                <td><form:radiobutton path="sot" value="1" required="required"/></td>
                <td><form:radiobutton path="sot" value="0" required="required"/></td>
                <td>Buồn nôn</td>
                <td><form:radiobutton path="non" value="1" required="required"/></td>
                <td><form:radiobutton path="non" value="0" required="required"/></td>
            </tr>
            <tr>
                <td>Ho</td>
                <td><form:radiobutton path="ho" value="1" required="required"/></td>
                <td><form:radiobutton path="ho" value="0" required="required"/></td>
                <td>Tiêu chảy</td>
                <td><form:radiobutton path="tieuchay" value="1" required="required"/></td>
                <td><form:radiobutton path="tieuchay" value="0" required="required"/></td>
            </tr>
            <tr>
                <td>Khó thở</td>
                <td><form:radiobutton path="khotho" value="1" required="required"/></td>
                <td><form:radiobutton path="khotho" value="0" required="required"/></td>
                <td>Xuất huyết ngoài da</td>
                <td><form:radiobutton path="xhngoaida" value="1" required="required"/></td>
                <td><form:radiobutton path="xhngoaida" value="0" required="required"/></td>
            </tr>
            <tr>
                <td>Đau họng</td>
                <td><form:radiobutton path="dauhong" value="1" required="required"/></td>
                <td><form:radiobutton path="dauhong" value="0" required="required"/></td>
                <td>Nổi ban ngoài da</td>
                <td><form:radiobutton path="noiban" value="1" required="required"/></td>
                <td><form:radiobutton path="noiban" value="0" required="required"/></td>
            </tr>
        </table>
    </div>
    <div class="row">
        <p>Lịch sử phơi nhiểm</p>
        <table>
            <tr>
                <th> </th>
                <th>Có</th>
                <th>Không</th>
            </tr>
            <tr>
                <td>Đến trang trại nuôi/chợ/cơ sở giết mổ</td>
                <td><form:radiobutton path="tiepxucdongvat" value="1" required="required"/></td>
                <td><form:radiobutton path="tiepxucdongvat" value="0" required="required"/></td>
            </tr>
            <tr>
                <td>Tiếp xúc gần 2 m với người nhiểm COVID</td>
                <td><form:radiobutton path="tiepxucnguoi" value="1" required="required"/></td>
                <td><form:radiobutton path="tiepxucnguoi" value="0" required="required"/></td>
            </tr>
        </table>
    </div>
    <div class="row">
        <form:button type="submit">submit</form:button>
    </div>
</form:form>
</body>
</html>